package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Keyword;
import com.cskaoyan14th.bean.KeywordExample;
import com.cskaoyan14th.mapper.KeywordMapper;
import com.cskaoyan14th.service.SearchService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    KeywordMapper keywordMapper;

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
}
