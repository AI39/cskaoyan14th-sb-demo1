package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Brand;
import com.cskaoyan14th.mapper.BrandMapper;
import com.cskaoyan14th.service.BrandService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:26
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    BrandMapper brandMapper;
    @Override
    public Page<Brand> queryBrandList(int page, int limit, Integer id, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<Brand> brandList1 = brandMapper.selectBrandList(id, name, sort, order);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList1);
        Page<Brand> brandList = new Page<>(pageInfo.getList(), pageInfo.getTotal());
        return brandList;
    }

    @Override
    public int deleteBrand(Brand brand) {
        int delete = brandMapper.deleteBrandById(brand.getId());
        return delete;
    }

    @Override
    public Brand createBrand(Brand brand) {
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        brand.setAddTime(date);
        brand.setUpdateTime(date);
        brandMapper.inserts(brand);
        Brand brand1 = brandMapper.selectById(brand.getId());
        return brand1;
    }

    @Override
    public Brand updateBrand(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);
        Brand brand1 = brandMapper.selectByPrimaryKey(brand.getId());
        return brand1;

    }

    /*微信中的方法实现*/
    @Override
    public List<Brand> queryWxBrandList(int page, int size) {
        PageHelper.startPage(page, size);
        List<Brand> WxBrandList1 = brandMapper.queryWxBrandList();
        PageInfo<Brand> pageInfo = new PageInfo<>(WxBrandList1);


        return pageInfo.getList();
    }

    @Override
    public Brand queryBrandDetail(int id) {
        Brand brand1 = brandMapper.selectByPrimaryKey(id);
        return brand1;
    }

    @Override
    public long queryCountBrand() {
        long count = brandMapper.countBrand();
        return count;
    }
}
