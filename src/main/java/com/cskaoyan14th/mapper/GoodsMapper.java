package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.CatAndBrandChildren;
import com.cskaoyan14th.bean.CategoryForGoods;
import com.cskaoyan14th.bean.Goods;
import com.cskaoyan14th.bean.GoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    Goods selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    /*以上为逆向工程生成*/

    List<CategoryForGoods> selectCategoryForGoods();

    List<CatAndBrandChildren> selectBrandsForGoods();

    List<Goods> selectLimit(@Param("limit") int limit);
}