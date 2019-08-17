package com.cwy.community.community.mapper;

import com.cwy.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gme_Create,gme_modified) values (#{name},#{account_id},#{token},#{gme_Create},#{gme_modified})")
    void insert(User user);


}
