package com.cwy.community.community.Controller;

import com.cwy.community.community.dto.AccesstokenDTO;
import com.cwy.community.community.dto.GitHubUser;
import com.cwy.community.community.provider.GitHubProvider;
import com.sun.xml.internal.stream.events.NamedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {


    @Autowired
    private GitHubProvider gitHubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name = "state") String state){
        AccesstokenDTO accesstokenDTO =new AccesstokenDTO();
        accesstokenDTO.setClient_id("92242cfd496ccb34c345");
        accesstokenDTO.setGetClient_secret("e23a4c94d3101c1485d347e0808cb4ad070d319a");
        accesstokenDTO.setRedirect_uri("http:localhost:8080/callback");
        accesstokenDTO.setState(state);
        String accesstoken = gitHubProvider.getAccesstoken(accesstokenDTO);
        GitHubUser user = gitHubProvider.gteuser(accesstoken);
        System.out.println(user.getName());
        return "index";
    }
}
