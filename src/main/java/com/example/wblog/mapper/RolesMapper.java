package com.example.wblog.mapper;

import com.example.wblog.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface RolesMapper {
//    int deleteByPrimaryKey(Long id);
//
//    int insert(Role record);
//
//    int insertSelective(Role record);
//
//    Role selectByPrimaryKey(Long id);
//
//    int updateByPrimaryKeySelective(Role record);
//
//    int updateByPrimaryKey(Role record);

    List<Role> getRolesByUid(Long uid);

    int addRoles(@Param("roles") String[] roles, @Param("uid") Long uid);
}