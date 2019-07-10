package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.SystemKeyValue;
import com.cskaoyan14th.mapper.SystemMapper;
import com.cskaoyan14th.service.SystemService;
import com.cskaoyan14th.vo.ResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
   SystemMapper systemMapper;

    @Override
    public String querySystemByKeyValue(String keyName) {

        return systemMapper.querySystemByKeyValue(keyName);
    }

    @Override
    public int updateSystemKeyValue(String keyValue, String keyName) {

        return systemMapper.updateSystemKeyValue(keyValue,keyName);
    }

    @Override
    public String querySystemByFrightMin(String keyName) {
        return systemMapper.querySystemByFrightMin(keyName);
    }

    @Override
    public int updateSystemByFrightMin(String keyValue, String keyName) {
        return systemMapper.updateSystemByFrightMin(keyValue,keyName);
    }

    @Override
    public String querySystemByOrder(String keyName) {
        return systemMapper.querySystemByOrder(keyName);
    }

    @Override
    public int updateSystemByOrder(String keyValue, String keyName) {

        return systemMapper.updateSystemByOrder(keyValue,keyName);
    }

    @Override
    public String querySystemByWx(String keyName) {
        return systemMapper.querySystemByWx(keyName);
    }

    @Override
    public int updateSystemByWx(String keyValue, String keyName) {

        return systemMapper.updateSystemByWx(keyValue, keyName);
    }

}

