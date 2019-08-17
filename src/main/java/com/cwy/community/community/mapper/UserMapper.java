package com.cwy.community.community.mapper;

import com.cwy.community.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gme_Create,gme_modified) values (#{name},#{account_id},#{token},#{gme_Create},#{gme_modified})")
    void insert(User user);


    @Select("select * from user where token = #{token}")
    User findBytoken(@Param("token") String token);
}
