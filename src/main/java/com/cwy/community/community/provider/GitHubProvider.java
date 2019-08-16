package com.cwy.community.community.provider;

import com.alibaba.fastjson.JSON;
import com.cwy.community.community.dto.AccesstokenDTO;
import com.cwy.community.community.dto.GitHubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component//这个注解的作用是把当前类初始化当Spring容器的上下文当中
public class GitHubProvider {

    /**
     * 获取access_token的值
     * @param accesstokenDTO
     * @return
     */
    public String getAccesstoken(AccesstokenDTO accesstokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
            RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accesstokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string = response.body().string();
                String token = string.split("&")[0].split("=")[1];
                return token;
            } catch (Exception  e) {
                e.printStackTrace();
            }
        return "null";
    }



    public GitHubUser gteuser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);//能够将json对象快速的转换为string对象
            return gitHubUser;
        } catch (IOException e) {
        }
        return null;
    }
}
