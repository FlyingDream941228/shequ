package com.cwy.community.community.Controller;

import com.cwy.community.community.Service.QuestionService;
import com.cwy.community.community.dto.QuestionDTO;
import com.cwy.community.community.mapper.UserMapper;
import com.cwy.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper um;

    @Autowired
    private QuestionService questionService;

    @RequestMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = um.findBytoken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
            List<QuestionDTO> quessList = questionService.List();
            model.addAttribute("question",quessList);
        }
        return "index";
    }
}