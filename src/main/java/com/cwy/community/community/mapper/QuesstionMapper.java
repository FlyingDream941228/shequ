package com.cwy.community.community.mapper;

import com.cwy.community.community.model.Quess;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuesstionMapper {
    @Insert("insert into question (title,description,gmt_create,gmt_modified,tag,creator) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{tag},${creator})")
    void create(Quess quess);

    @Select("select * from question")
    List<Quess> List();
}
