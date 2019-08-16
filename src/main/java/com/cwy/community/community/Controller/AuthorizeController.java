package com.cwy.community.community.Controller;

import com.cwy.community.community.dto.AccesstokenDTO;
import com.cwy.community.community.dto.GitHubUser;
import com.cwy.community.community.provider.GitHubProvider;
import com.sun.xml.internal.stream.events.NamedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {


    @Autowired
    private GitHubProvider gitHubProvider;

    @Value("${github.client.id}")
    private String clientid;
    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect_uri}")
    private String redirecturi;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state){

        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setCode(code);
        accesstokenDTO.setRedirect_uri(redirecturi);
        accesstokenDTO.setClient_id(clientid);
        accesstokenDTO.setClient_secret(clientSecret);
        accesstokenDTO.setState(state);
        String accesstoken = gitHubProvider.getAccesstoken(accesstokenDTO);
        GitHubUser user = gitHubProvider.gteuser(accesstoken);
        System.out.println(user.getName());
        return "index";
    }
}
