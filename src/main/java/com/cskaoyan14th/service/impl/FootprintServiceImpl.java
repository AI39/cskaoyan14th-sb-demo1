package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Brand;
import com.cskaoyan14th.bean.Footprint;
import com.cskaoyan14th.bean.User;
import com.cskaoyan14th.mapper.FootprintMapper;
import com.cskaoyan14th.service.FootprintService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootprintServiceImpl implements FootprintService {

    @Autowired
    FootprintMapper footprintMapper;

    @Override
    public Page<Footprint> getPageList(int page, int limit, String sort, String order) {

        PageHelper.startPage(page,limit);
        List<Footprint> footprints = footprintMapper.selectFootprintListOrder(sort, order);

        PageInfo<Footprint> pageInfo = new PageInfo<>(footprints);
        Page<Footprint> footprintList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());

        return footprintList;
    }

    @Override
    public Page<Footprint> getPageList(int page, int limit, String userId, String goodsId, String sort, String order) {

        PageHelper.startPage(page,limit);
        List<Footprint> footprints = footprintMapper.selectFootprintListOrder(userId,goodsId,sort, order);

        PageInfo<Footprint> pageInfo = new PageInfo<>(footprints);
        Page<Footprint> footprintList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());

        return footprintList;
    }

    @Override
    public List<Footprint> queryFootprintList(Integer page, Integer size) {

        PageHelper.startPage(page, size);
        List<Footprint> footprintList =  footprintMapper.selectFootprintList();
        PageInfo<Footprint> pageInfo = new PageInfo<>(footprintList);

        return pageInfo.getList();
    }

    @Override
    public int queryFootprintTotalPages(Integer page, Integer size) {

        PageHelper.startPage(page, size);

        List<Footprint> footprintList =  footprintMapper.selectFootprintList();
        PageInfo<Footprint> pageInfo = new PageInfo<>(footprintList);

        return pageInfo.getPages();
    }
}
