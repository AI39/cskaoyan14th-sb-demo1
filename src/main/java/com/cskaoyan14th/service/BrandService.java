package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Brand;
import com.cskaoyan14th.vo.Page;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:26
 */
public interface BrandService {

    Page<Brand> queryBrandList(int page, int limit, Integer id, String name, String sort, String order);

    int deleteBrand(Brand brand);

    Brand createBrand(Brand brand);

    Brand updateBrand(Brand brand);
}
