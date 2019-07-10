package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Keyword;
import com.cskaoyan14th.bean.KeywordExample;
import com.cskaoyan14th.bean.SearchHistory;
import com.cskaoyan14th.bean.SearchHistoryExample;
import com.cskaoyan14th.mapper.KeywordMapper;
import com.cskaoyan14th.mapper.SearchHistoryMapper;
import com.cskaoyan14th.service.SearchService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    KeywordMapper keywordMapper;

    @Autowired
    SearchHistoryMapper searchHistoryMapper;

    @Override
    public Keyword getDefaultKeyWord() {

        PageHelper.startPage(1,1);
        KeywordExample keywordExample = new KeywordExample();
        KeywordExample.Criteria criteria = keywordExample.createCriteria();
        criteria.andIsHotEqualTo(true);
        List<Keyword> keywords = keywordMapper.selectByExample(keywordExample);

        if(keywords != null && keywords.size() != 0) {
            return keywords.get(0);
        }
        return null;
    }

    @Override
    public List<Keyword> getHotKeywordList() {

        KeywordExample keywordExample = new KeywordExample();
        KeywordExample.Criteria criteria = keywordExample.createCriteria();
        criteria.andIsHotEqualTo(true);

        List<Keyword> keywords = keywordMapper.selectByExample(keywordExample);
        return keywords;
    }

    @Override
    public List<Map<String, String>> getHistoryKeywordList(Integer userId) {

        List<Map<String, String>> historyKeywordList = new ArrayList<>();

        SearchHistoryExample searchHistoryExample = new SearchHistoryExample();
        SearchHistoryExample.Criteria criteria = searchHistoryExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        List<SearchHistory> searchHistories = searchHistoryMapper.selectByExample(searchHistoryExample);

        for(SearchHistory searchHistory : searchHistories) {
            HashMap<String, String> map = new HashMap<>();
            map.put("keyword", searchHistory.getKeyword());
            historyKeywordList.add(map);
        }
        return historyKeywordList;
    }

    @Override
    public int clearHistoryByUserId(Integer userId) {

        SearchHistoryExample searchHistoryExample = new SearchHistoryExample();
        SearchHistoryExample.Criteria criteria = searchHistoryExample.createCriteria();
        criteria.andUserIdEqualTo(userId);

        int i = searchHistoryMapper.deleteByExample(searchHistoryExample);
        return i;
    }

    @Override
    public List<String> getFussyKeyword(String keyword) {

        KeywordExample keywordExample = new KeywordExample();
        KeywordExample.Criteria criteria = keywordExample.createCriteria();
        criteria.andKeywordLike("%" + keyword + "%");
        List<Keyword> keywords = keywordMapper.selectByExample(keywordExample);
        List<String> list = new ArrayList<>();

        for(Keyword k : keywords) {
            list.add(k.getKeyword());
        }
        return list;
    }
}
