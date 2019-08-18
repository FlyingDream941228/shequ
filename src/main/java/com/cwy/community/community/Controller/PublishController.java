package com.cwy.community.community.Controller;

import com.cwy.community.community.mapper.QuesstionMapper;
import com.cwy.community.community.mapper.UserMapper;
import com.cwy.community.community.model.Quess;
import com.cwy.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {
    @Autowired
    private QuesstionMapper qm;
    @Autowired
    private UserMapper um;


    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublicsh(
            @RequestParam(value="title", required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "teg", required = false) String tag,
            HttpServletRequest request,
            Model model){
        if(title == null || title== ""){
            model.addAttribute("error","标题不能为空");
            return "publish";
        }
        if(description == null || description== ""){
            model.addAttribute("error","问题补充不能为空");
            return "publish";
        }

        model.addAttribute("title","title");
        model.addAttribute("description","description");
        model.addAttribute("teg","teg");
        System.out.println("1111111111");
        //在cookie中获取用户信息
        User user = null;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token = cookie.getValue();
                user = um.findBytoken(token);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
                break;
            }
        }
        if(user == null){
            model.addAttribute("error","用户未登录");
            return "publish";
        }

        System.out.println("2222222222222");
        //获取前段用户输入的内容并将其存入数据库中
        Quess quess = new Quess();
        quess.setDescription(description);
        quess.setTag(tag);
        quess.setTitle(title);
        quess.setCreator(user.getId());
        quess.setGmt_create(System.currentTimeMillis());
        quess.setGmt_modified(quess.getGmt_create());
        qm.create(quess);
        //发布成功之后返回到index首页
        return "redirect:/";
    }
}
