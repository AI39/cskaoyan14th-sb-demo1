package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.bean.AddressExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {
    long countByExample(AddressExample example);

    int deleteByExample(AddressExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    int insertSelective(Address record);

    List<Address> selectByExample(AddressExample example);

    Address selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);


    List<Address> selectAddressListOrder(@Param("sort") String sort, @Param("order") String order);
    List<Address> selectAddressListOrder(@Param("name") String name,@Param("userId") String userId,
                                         @Param("sort") String sort, @Param("order") String order);

    List<Address> getListById(@Param("uid") int uid);
    List<Address> getListById();
    Address getDefaultAddress(@Param("uid") int uid);

}