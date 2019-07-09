package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Log;
import com.cskaoyan14th.bean.LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogMapper {


    List<Log> queryAdminAll(@Param("name") String name);
}