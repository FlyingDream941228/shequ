package com.cwy.community.community.model;

public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gme_Create;
    private Long gme_modified;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account_id='" + account_id + '\'' +
                ", token='" + token + '\'' +
                ", gme_Create=" + gme_Create +
                ", gme_modified=" + gme_modified +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getGme_Create() {
        return gme_Create;
    }

    public void setGme_Create(Long gme_Create) {
        this.gme_Create = gme_Create;
    }

    public Long getGme_modified() {
        return gme_modified;
    }

    public void setGme_modified(Long gme_modified) {
        this.gme_modified = gme_modified;
    }
}
