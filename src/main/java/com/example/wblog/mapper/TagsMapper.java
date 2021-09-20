package com.example.wblog.mapper;

import com.example.wblog.bean.Tags;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tags record);

    int insertSelective(Tags record);

    Tags selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);

    List<Long> getTagsIdByTagName(@Param("tagNames") String[] tagNames);
}