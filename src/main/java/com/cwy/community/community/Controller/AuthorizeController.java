package com.cwy.community.community.Controller;

import com.cwy.community.community.mapper.UserMapper;
import com.cwy.community.community.dto.AccesstokenDTO;
import com.cwy.community.community.dto.GitHubUser;
import com.cwy.community.community.model.User;
import com.cwy.community.community.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Controller
public class AuthorizeController {


    @Autowired
    private GitHubProvider gitHubProvider;
    @Autowired
    private UserMapper um;

    @Value("${github.client.id}")
    private String clientid;
    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect_uri}")
    private String redirecturi;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest req){

        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setCode(code);
        accesstokenDTO.setRedirect_uri(redirecturi);
        accesstokenDTO.setClient_id(clientid);
        accesstokenDTO.setClient_secret(clientSecret);
        accesstokenDTO.setState(state);
        String accesstoken = gitHubProvider.getAccesstoken(accesstokenDTO);
        GitHubUser gitHubUser = gitHubProvider.gteuser(accesstoken);
        if (gitHubUser!=null){
            User user = new User();
            user.setToken(UUID.randomUUID().toString());
            user.setName(gitHubUser.getName());
            user.setAccount_id(String.valueOf(gitHubUser.getId()));
            user.setGme_Create(System.currentTimeMillis());
            user.setGme_modified(user.getGme_Create());
            um.insert(user);
            //登录成功 写cooke和session
            //将user放入session中
            req.getSession().setAttribute("user",gitHubUser);
            //跳转到首页
            return "redirect:/";//redirect返回的是路径
        }else {
            return "redirect:/";
        }
    }
}
