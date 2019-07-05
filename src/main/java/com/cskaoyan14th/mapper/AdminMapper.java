package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Admin;
import com.cskaoyan14th.bean.AdminExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {

    List<Admin> queryAdminAll();

    int insertAdmin(@Param("adm") Admin admin);

    Admin queryAdminByUsername(@Param("user") Admin username);

    int updatetAdmin(@Param("admin") Admin admin);

    Admin queryAdminById(@Param("aid") Admin id);

    int deleteAdmin(@Param("admin") Admin admin);

    List<Admin> queryAdminAllByUsername(@Param("user") String username);
}