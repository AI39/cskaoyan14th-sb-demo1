package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.SearchHistory;
import com.cskaoyan14th.bean.User;
import com.cskaoyan14th.mapper.SearchHistoryMapper;
import com.cskaoyan14th.service.SearchHistoryService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchHistoryServiceImpl implements SearchHistoryService {

    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public Page<SearchHistory> getPageList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<SearchHistory> histories = searchHistoryMapper.selectSearchHistoryOrder(sort, order);
        PageInfo<SearchHistory> pageInfo = new PageInfo<>(histories);
        Page<SearchHistory> historyList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        return historyList;
    }

    @Override
    public Page<SearchHistory> getPageList(int page, int limit, String userId, String keyword, String sort, String order) {

        PageHelper.startPage(page,limit);

        List<SearchHistory> histories = searchHistoryMapper.selectSearchHistoryOrder(userId,keyword,sort, order);
        PageInfo<SearchHistory> pageInfo = new PageInfo<>(histories);
        Page<SearchHistory> historyList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());

        return historyList;
    }
}
