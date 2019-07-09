package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.GrouponRules;
import com.cskaoyan14th.mapper.GrouponRulesMapper;
import com.cskaoyan14th.service.GrouponRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrouponRulesServiceImpl implements GrouponRulesService {
    @Autowired
    GrouponRulesMapper grouponRulesMapper;
    @Override
    public double getGrouponPrice(int grouponRulesId) {
        return grouponRulesMapper.selectByPrimaryKey(grouponRulesId).getDiscount().doubleValue();
    }
}
