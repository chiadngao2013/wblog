package com.example.wblog.mapper;

import com.example.wblog.bean.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TagsMapper {
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Tags record);

    int saveTags(@Param("tags") String[] tags);

//    int insertSelective(Tags record);
//
//    Tags selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Tags record);
//
//    int updateByPrimaryKey(Tags record);

    int deleteTagsByAid(Long aid);

    int saveTags2ArticleTags(@Param("tagIds") List<Long> tagIds, @Param("aid") Long aid);

    List<Long> getTagsIdByTagName(@Param("tagNames") String[] tagNames);
}