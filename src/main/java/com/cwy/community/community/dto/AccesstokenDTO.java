package com.cwy.community.community.dto;

public class AccesstokenDTO {
    private String client_id;
    private String getClient_secret;
    private String code;
    private String redirect_uri;
    private String state;

    public String getClient_id() {
        return client_id;
    }

    public String getGetClient_secret() {
        return getClient_secret;
    }

    public String getCode() {
        return code;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public String getState() {
        return state;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setGetClient_secret(String getClient_secret) {
        this.getClient_secret = getClient_secret;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public void setState(String state) {
        this.state = state;
    }
}
