package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.*;
import com.cskaoyan14th.service.GoodsService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.wrapper.FloorGoods;
import com.cskaoyan14th.wrapper.GoodsDetail;
import com.cskaoyan14th.wrapper.GoodsParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

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
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Autowired
    IssueMapper issueMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    SearchHistoryMapper searchHistoryMapper;

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

    @Override
    public List<Goods> getNewGoodsList(int newGoodsCount) {
        PageHelper.startPage(1, newGoodsCount);

        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIsNewEqualTo(true);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        return goodsList;
    }

    @Override
    public List<FloorGoods> getFloorGoodsList(int catlogCount, int catlogGoodsCount) {
        PageHelper.startPage(1, catlogCount);
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();
        criteria.andPidEqualTo(0);
        List<Category> categories = categoryMapper.selectByExample(categoryExample);

        List<FloorGoods> floorGoodsList = new ArrayList<>();
        int limit = catlogGoodsCount;
        for(Category category : categories) {
            List<Goods> goodsList = goodsMapper.selectLimitByParentCategoryId(category.getId(), limit);
            FloorGoods floorGoods = new FloorGoods();
            floorGoods.setGoodsList(goodsList);
            floorGoods.setId(category.getId());
            floorGoods.setName(category.getName());
            floorGoodsList.add(floorGoods);
        }
        return floorGoodsList;
    }

    @Override
    public List<Goods> getHotGoodsList(int hotGoodsCount) {
        PageHelper.startPage(1, hotGoodsCount);
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andIsHotEqualTo(true);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);

        return goodsList;
    }

    @Override
    public int getGoodsCount() {
        int count = goodsMapper.selectCount();

        return count;
    }

    @Override
    public List<Goods> getGoodsListByPage(String keyword, int page, int size, String sort, String order, Integer categoryId, Integer brandId) {
        PageHelper.startPage(page, size);

        GoodsExample goodsExample = new GoodsExample();
        if((sort != null && sort.length() != 0) && (order != null && order.length() != 0)) {
            goodsExample.setOrderByClause(sort + " " + order);
        }
        GoodsExample.Criteria criteria = goodsExample.createCriteria();

        if(keyword != null && keyword.length() != 0) {
            criteria.andNameLike("%" + keyword + "%");
        }
        if (categoryId != null && categoryId != 0){
            criteria.andCategoryIdEqualTo(categoryId);
        }
        if (brandId != null && brandId != 0) {
            criteria.andBrandIdEqualTo(brandId);
        }

        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsList);
        return pageInfo.getList();
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

    @Override
    public GoodsDetail getGoodsDetailByGoodsId(int id) {
        GoodsDetail goodsDetail = new GoodsDetail();

        //获取specificationList
        List<Map<String, Object>> specificationList = new ArrayList<>();
        List<String> specifications = goodsSpecificationMapper.selectDistinctSpecificationByGoodsId(id);

        for(String specification : specifications) {

            HashMap<String, Object> map = new HashMap<>();

            map.put("name", specification);

            GoodsSpecificationExample goodsSpecificationExample = new GoodsSpecificationExample();
            GoodsSpecificationExample.Criteria criteria = goodsSpecificationExample.createCriteria();
            criteria.andSpecificationEqualTo(specification).andGoodsIdEqualTo(id);
            List<GoodsSpecification> valueList = goodsSpecificationMapper.selectByExample(goodsSpecificationExample);
            map.put("valueList", valueList);
            specificationList.add(map);
        }
        goodsDetail.setSpecificationList(specificationList);

        //获取groupon
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        GrouponRulesExample.Criteria grouponRulesExampleCriteria = grouponRulesExample.createCriteria();
        grouponRulesExampleCriteria.andGoodsIdEqualTo(id);
        List<GrouponRules> groupon = grouponRulesMapper.selectByExample(grouponRulesExample);
        goodsDetail.setGroupon(groupon);

        //获取issue
        IssueExample issueExample = new IssueExample();
        IssueExample.Criteria issueExampleCriteria = issueExample.createCriteria();
        issueExampleCriteria.andIdIsNotNull();
        List<Issue> issue = issueMapper.selectByExample(issueExample);
        goodsDetail.setIssue(issue);

        //获取userHasCollect用户是否有收藏
        CollectExample collectExample = new CollectExample();
        CollectExample.Criteria collectExampleCriteria = collectExample.createCriteria();
        collectExampleCriteria.andValueIdEqualTo(id);
        List<Collect> userHasCollect = collectMapper.selectByExample(collectExample);
        if(userHasCollect == null || userHasCollect.size() == 0) {
            goodsDetail.setUserHasCollect(0);
        } else {
            goodsDetail.setUserHasCollect(1);
        }

        //获取shareImage
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        String shareImage = goods.getShareUrl();
        goodsDetail.setShareImage(shareImage);

        //获取comment
        int limit = 2;
        List<CommentForGoodsDetail> data = commentMapper.selectLimitCommentForGoodsDetailByGoodId(id, limit);
        int count = commentMapper.selectCountByGoodsId(id);
        HashMap<String, Object> comment = new HashMap<>();
        comment.put("data", data);
        comment.put("count", count);
        goodsDetail.setComment(comment);

        //获取attribute
        GoodsAttributeExample goodsAttributeExample = new GoodsAttributeExample();
        GoodsAttributeExample.Criteria goodsAttributeExampleCriteria = goodsAttributeExample.createCriteria();
        goodsAttributeExampleCriteria.andGoodsIdEqualTo(id);
        List<GoodsAttribute> attribute = goodsAttributeMapper.selectByExample(goodsAttributeExample);
        goodsDetail.setAttribute(attribute);

        //获取brand
        Brand brand = brandMapper.selectByPrimaryKey(goods.getBrandId());
        goodsDetail.setBrand(brand);

        //获取productList
        GoodsProductExample goodsProductExample = new GoodsProductExample();
        GoodsProductExample.Criteria goodsProductExampleCriteria = goodsProductExample.createCriteria();
        goodsProductExampleCriteria.andGoodsIdEqualTo(id);
        List<GoodsProduct> productList = goodsProductMapper.selectByExample(goodsProductExample);
        goodsDetail.setProductList(productList);

        //获取info
        goodsDetail.setInfo(goods);


        return goodsDetail;
    }

    @Override
    public List<Goods> getRelatedGoods(int id) {
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        Integer categoryId = goods.getCategoryId();
        GoodsExample goodsExample = new GoodsExample();
        GoodsExample.Criteria goodsExampleCriteria = goodsExample.createCriteria();
        goodsExampleCriteria.andCategoryIdEqualTo(categoryId);
        List<Goods> goodsList = goodsMapper.selectByExample(goodsExample);
        List<Goods> goodsListLimit = new ArrayList<>();
        int limit = 5;
        for (int i = 0; i < limit && i < goodsList.size(); i++) {
            goodsListLimit.add(goodsList.get(i));
        }
        return goodsListLimit;
    }

    @Override
    public Map<String, Object> getCurrentBrotherParentGatogory(int id) {
        Map<String, Object> map = new HashMap<>();
        CategoryExample categoryExample = new CategoryExample();
        CategoryExample.Criteria criteria = categoryExample.createCriteria();

        Category category = categoryMapper.selectByPrimaryKey(id);
        if(category.getPid() == 0) {

            Category parentCategory = categoryMapper.selectByPrimaryKey(id);
            map.put("parentCategory", parentCategory);


            criteria.andPidEqualTo(id);
            List<Category> brotherCategory = categoryMapper.selectByExample(categoryExample);
            map.put("brotherCategory", brotherCategory);

            if (brotherCategory != null && brotherCategory.size() != 0) {
                map.put("currentCategory", brotherCategory.get(0));
            }
        } else {
            Category parentCategory = categoryMapper.selectByPrimaryKey(category.getPid());
            map.put("parentCategory", parentCategory);

            criteria.andPidEqualTo(category.getPid());
            List<Category> brotherCategory = categoryMapper.selectByExample(categoryExample);
            map.put("brotherCategory", brotherCategory);

            map.put("currentCategory", category);
        }

        return map;
    }

    @Override
    public int insertSearchHistory(Integer userId, String keyword) {
        SearchHistory searchHistory = new SearchHistory();
        searchHistory.setAddTime(new Date());
        searchHistory.setDeleted(false);
        searchHistory.setKeyword(keyword);
        searchHistory.setUpdateTime(new Date());
        searchHistory.setUserId(userId);
        int i = searchHistoryMapper.insertSelective(searchHistory);
        return i;
    }
}
