package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.User;
import com.cskaoyan14th.bean.UserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUserListOrder(@Param("sort") String sort, @Param("order") String order);
    List<User> selectUserListOrder(@Param("username") String username,@Param("mobile") String mobile,
                                   @Param("sort") String sort, @Param("order") String order);

    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}