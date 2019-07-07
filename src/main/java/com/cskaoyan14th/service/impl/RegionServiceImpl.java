package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Region;
import com.cskaoyan14th.mapper.RegionMapper;
import com.cskaoyan14th.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:25
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    RegionMapper regionMapper;
    @Override
    public List<Region> queryRegionList() {
        List<Region> regionList = regionMapper.queryRegionList();
        return regionList;
    }
}
