package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Brand;
import com.cskaoyan14th.bean.BrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {

    long countByExample(BrandExample example);

    int deleteByExample(BrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Brand record);

    int insertSelective(Brand record);

    List<Brand> selectByExample(BrandExample example);

    Brand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    int updateByPrimaryKeySelective(Brand record);

    int updateByPrimaryKey(Brand record);

    List<Brand> selectBrandList(@Param("id") Integer id,@Param("name") String name,@Param("sort") String sort,@Param("order") String order);

    int inserts(Brand brand);

    Brand selectById(Integer id);

    int deleteBrandById(Integer id);

    /*微信*/

    List<Brand> queryWxBrandList();

    long countBrand();

}