package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Keyword;
import com.cskaoyan14th.mapper.KeywordMapper;
import com.cskaoyan14th.service.KeywordService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:30
 */
@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    KeywordMapper keywordMapper;

    @Override
    public Page<Keyword> queryKeywordList(int page, int limit, String keyword, String url, String sort, String order) {

        PageHelper.startPage(page,limit);
        List<Keyword> keywordList1 = keywordMapper.queryKeywordList(keyword, url, sort, order);
        PageInfo<Keyword> pageInfo = new PageInfo<>(keywordList1);
        Page<Keyword> keywordList = new Page<>(pageInfo.getList(), pageInfo.getTotal());

        return keywordList;
    }

    @Override
    public Keyword updateKeyword(Keyword keyword) {

        keywordMapper.updateByPrimaryKey(keyword);
        Keyword keyword1 = keywordMapper.selectByPrimaryKey(keyword.getId());

        return keyword1;
    }

    @Override
    public int deleteKeyword(Keyword keyword) {

        int delete = keywordMapper.deleteById(keyword.getId());

        return delete;
    }

    @Override
    public Keyword createKeyword(Keyword keyword) {

        long l = System.currentTimeMillis();
        Date date = new Date(l);

        keyword.setAddTime(date);
        keyword.setUpdateTime(date);

        keywordMapper.inserts(keyword);
        Keyword keyword1 = keywordMapper.selectByPrimaryKey(keyword.getId());

        return  keyword1;
    }
}
