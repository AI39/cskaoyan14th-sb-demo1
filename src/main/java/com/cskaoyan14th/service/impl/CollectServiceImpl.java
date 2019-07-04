package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Address;
import com.cskaoyan14th.bean.Collect;
import com.cskaoyan14th.mapper.CollectMapper;
import com.cskaoyan14th.service.CollectService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    CollectMapper collectMapper;

    @Override
    public Page<Collect> getPageList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Collect> collects = collectMapper.selectCollectListOrder(sort, order);
        PageInfo<Collect> pageInfo = new PageInfo<>(collects);
        Page<Collect> collectList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        return collectList;
    }
}
