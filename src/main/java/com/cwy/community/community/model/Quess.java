package com.cwy.community.community.model;

import lombok.Data;

@Data
public class Quess {

    private Integer id;
    private String title;
    private String description;
    private long gmt_create;
    private long gmt_modified;
    private Integer creator;
    private Integer comment_count;
    private Integer view_count;
    private Integer like_count;
    private  String tag;


}
