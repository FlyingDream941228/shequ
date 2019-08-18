package com.cwy.community.community.model;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gme_Create;
    private Long gme_modified;
    private String avatr_url;


}
