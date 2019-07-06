package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.*;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.wrapper.GoodsParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;
    @Autowired
    GoodsSpecificationMapper goodsSpecificationMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryForGoods> getCategoryForGoods() {
        return goodsMapper.selectCategoryForGoods();
    }

    @Override
    public List<CatAndBrandChildren> getBrandForGoods() {
        return goodsMapper.selectBrandsForGoods();
    }

    @Override
    public Boolean goodsNameIsExist(String name) {
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andNameEqualTo(name);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        if(goodsList != null && goodsList.size() != 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean insertGoods4(GoodsParam goodsParam) {
        Date date = new Date();
        //获取参数
        Goods goods = goodsParam.getGoods();
        GoodsSpecification[] specifications = goodsParam.getSpecifications();
        GoodsProduct[] products = goodsParam.getProducts();
        GoodsAttribute[] attributes = goodsParam.getAttributes();

        try {
            // 插入goods并获取id
            goods.setAddTime(date);
            goods.setUpdateTime(date);
            goodsMapper.insertSelective(goods);
            int id = goods.getId();

            //封装goodsId,插入数据库
            for (GoodsSpecification goodsSpecification : specifications) {
                goodsSpecification.setAddTime(date);
                goodsSpecification.setUpdateTime(date);
                goodsSpecification.setGoodsId(id);
                goodsSpecificationMapper.insertSelective(goodsSpecification);
            }

            for (GoodsProduct goodsProduct : products) {
                goodsProduct.setAddTime(date);
                goodsProduct.setUpdateTime(date);
                goodsProduct.setId(null);
                goodsProduct.setGoodsId(id);
                goodsProductMapper.insertSelective(goodsProduct);
            }

            for (GoodsAttribute goodsAttribute : attributes) {
                goodsAttribute.setAddTime(date);
                goodsAttribute.setUpdateTime(date);
                goodsAttribute.setGoodsId(id);
                goodsAttributeMapper.insertSelective(goodsAttribute);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    @Override
    public GoodsParam getGoodsParam(int id) {
        GoodsParam goodsParam = new GoodsParam();
        //获取categoryIds
        int[] categoryIds = new int[2];

        Goods goods = goodsMapper.selectByPrimaryKey(id);
        int childCategoryId = goods.getCategoryId();
        categoryIds[1] = childCategoryId;

        Category category = categoryMapper.selectByPrimaryKey(childCategoryId);
        int parentCategoryId = 0;
        if(category != null) {
            parentCategoryId = category.getPid();
        }
        categoryIds[0] = parentCategoryId;

        goodsParam.setCategoryIds(categoryIds);

        //获取goods
        goodsParam.setGoods(goods);

        //获取attributes
        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        GoodsAttributeExample.Criteria goodsAttributeExampleCriteria = goodsAttributeExample.createCriteria();
        goodsAttributeExampleCriteria.andGoodsIdEqualTo(id);
        List<GoodsAttribute> goodsAttributesList = goodsAttributeMapper.selectByExample(goodsAttributeExample);
        GoodsAttribute[] attributes = new GoodsAttribute[goodsAttributesList.size()];
        goodsAttributesList.toArray(attributes);
        goodsParam.setAttributes(attributes);

        //获取specifications
        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        GoodsSpecificationExample.Criteria goodsSpecificationExampleCriteria = goodsSpecificationExample.createCriteria();
        goodsSpecificationExampleCriteria.andGoodsIdEqualTo(id);
        List<GoodsSpecification> goodsSpecificationList = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);
        GoodsSpecification[] specifications = new GoodsSpecification[goodsSpecificationList.size()];
        goodsSpecificationList.toArray(specifications);
        goodsParam.setSpecifications(specifications);

        //获取products
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        GoodsProductExample.Criteria goodsProductExampleCriteria = goodsProductExample.createCriteria();
        goodsProductExampleCriteria.andGoodsIdEqualTo(id);
        List<GoodsProduct> goodsProductList = goodsProductMapper.selectByExample(goodsProductExample);
        GoodsProduct[] products = new GoodsProduct[goodsProductList.size()];
        goodsProductList.toArray(products);
        goodsParam.setProducts(products);

        return goodsParam;
    }

    @Override
    @Transactional
    public Boolean updateGoods4(GoodsParam goodsParam) {
        Date date = new Date();
        //获取参数
        Goods goods = goodsParam.getGoods();
        GoodsSpecification[] specifications = goodsParam.getSpecifications();
        GoodsProduct[] products = goodsParam.getProducts();
        GoodsAttribute[] attributes = goodsParam.getAttributes();

        try {
            //更新goods
            goodsMapper.updateByPrimaryKeySelective(goods);

            //删除子表
            deleteGoodsSpecificationByGoodsId(goods.getId());
            deleteGoodsProductByGoodsId(goods.getId());
            deleteGoodsAttributeByGoodsId(goods.getId());

            //insert子表
            for (GoodsSpecification goodsSpecification : specifications) {
                goodsSpecification.setAddTime(date);
                goodsSpecification.setUpdateTime(date);
                goodsSpecification.setGoodsId(goods.getId());
                goodsSpecificationMapper.insertSelective(goodsSpecification);
            }

            for (GoodsProduct goodsProduct : products) {
                goodsProduct.setAddTime(date);
                goodsProduct.setUpdateTime(date);
                goodsProduct.setId(null);
                goodsProduct.setGoodsId(goods.getId());
                goodsProductMapper.insertSelective(goodsProduct);
            }

            for (GoodsAttribute goodsAttribute : attributes) {
                goodsAttribute.setAddTime(date);
                goodsAttribute.setUpdateTime(date);
                goodsAttribute.setGoodsId(goods.getId());
                goodsAttributeMapper.insertSelective(goodsAttribute);
            }
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }

        return true;
    }

    @Override
    @Transactional
    public Boolean deleteGoods4(Goods goods) {
        Integer id = goods.getId();
        try {
            goodsMapper.deleteByPrimaryKey(id);
            deleteGoodsSpecificationByGoodsId(id);
            deleteGoodsProductByGoodsId(id);
            deleteGoodsAttributeByGoodsId(id);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return true;
    }

    @Override
    public Page<Goods> getGoodsPage(int page, int limit, String goodsSn, String name, String sort, String order) {
        PageHelper.startPage(page, limit);

        GoodsExample goodsExample = new GoodsExample();
        goodsExample.setOrderByClause(sort + " " + order);
        GoodsExample.Criteria criteria = goodsExample.createCriteria();

        if((goodsSn == null || goodsSn.length() == 0) && (name == null || name.length() == 0)) {
            criteria.andIdIsNotNull();
        } else if((goodsSn != null && goodsSn.length() > 0) && (name == null || name.length() == 0)) {  //只查询商品编号
            criteria.andGoodsSnLike("%" + goodsSn + "%");
        } else if((goodsSn == null || goodsSn.length() == 0) && (name != null && name.length() != 0)) { //只查询商品名称
            criteria.andNameLike("%" + name + "%");
        } else {
            criteria.andGoodsSnLike("%" + goodsSn + "%").andNameLike("%" + name + "%");
        }

        List<Goods> goodsList = goodsList = goodsMapper.selectByExample(goodsExample);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        Page<Goods> goodsPage = new Page<>(pageInfo.getList(),pageInfo.getTotal());
        return goodsPage;
    }

    private void deleteGoodsAttributeByGoodsId(Integer id) {
        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        GoodsAttributeExample.Criteria goodsAttributeExampleCriteria = goodsAttributeExample.createCriteria();
        goodsAttributeExampleCriteria.andGoodsIdEqualTo(id);
        goodsAttributeMapper.deleteByExample(goodsAttributeExample);
    }

    private void deleteGoodsProductByGoodsId(Integer id) {
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        GoodsProductExample.Criteria goodsProductExampleCriteria = goodsProductExample.createCriteria();
        goodsProductExampleCriteria.andGoodsIdEqualTo(id);
        goodsProductMapper.deleteByExample(goodsProductExample);
    }

    private void deleteGoodsSpecificationByGoodsId(Integer id) {
        GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
        GoodsSpecificationExample.Criteria goodsSpecificationExampleCriteria = goodsSpecificationExample.createCriteria();
        goodsSpecificationExampleCriteria.andGoodsIdEqualTo(id);
        goodsSpecificationMapper.deleteByExample(goodsSpecificationExample);
    }


}
