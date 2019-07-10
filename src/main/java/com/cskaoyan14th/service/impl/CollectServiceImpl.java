package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Collect;
import com.cskaoyan14th.bean.CollectExample;
import com.cskaoyan14th.mapper.CollectMapper;
import com.cskaoyan14th.service.CollectService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.wrapper.CollectData;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Page<Collect> getPageList(int page, int limit, String userId, String valueId, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Collect> collects = collectMapper.selectCollectListOrder(userId,valueId,sort, order);
        PageInfo<Collect> pageInfo = new PageInfo<>(collects);
        Page<Collect> collectList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        return collectList;
    }

    @Override
    public Map<String, Object> getCollectDataList(int page, int size, int userId, int type) {
        PageHelper.startPage(page, size);
        List<CollectData> collects = collectMapper.selectCollectDataListByUserId(userId, type);
        PageInfo<CollectData> pageInfo = new PageInfo<>(collects);

        Map<String, Object> map = new HashMap<>();
        map.put("collectList", pageInfo.getList());
        map.put("totalPages", pageInfo.getPages());

        return map;
    }

    @Override
    public String addordeleteCollect(int userId, int valueId) {
        String result = "";

        CollectExample collectExample = new CollectExample();
        CollectExample.Criteria criteria = collectExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andValueIdEqualTo(valueId);

        List<Collect> collectList = collectMapper.selectByExample(collectExample);
        Collect newCollect = new Collect();
        if (collectList == null || collectList.size() == 0) {
            newCollect.setUserId(userId);
            newCollect.setValueId(valueId);
            newCollect.setType((byte)0);
            newCollect.setAddTime(new Date());
            newCollect.setUpdateTime(new Date());
            newCollect.setDeleted(false);
            collectMapper.insertSelective(newCollect);

            result = "add";
        }
        else {
            Collect collect = collectList.get(0);
            if (collect.getType() == 0) {
                collect.setType((byte) 1);
                collect.setDeleted(true);
                result = "delete";
            } else {
                collect.setType((byte) 0);
                collect.setDeleted(false);
                result = "add";
            }
            collect.setUpdateTime(new Date());
            collectMapper.updateByPrimaryKeySelective(collect);
        }

        return result;
    }
}
