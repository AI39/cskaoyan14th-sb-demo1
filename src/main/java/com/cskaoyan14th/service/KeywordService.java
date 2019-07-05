package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Keyword;
import com.cskaoyan14th.vo.Page;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:29
 */
public interface KeywordService {
    Page<Keyword> queryKeywordList(int page, int limit, String keyword, String url, String sort, String order);

    Keyword updateKeyword(Keyword keyword);

    int deleteKeyword(Keyword keyword);

    Keyword createKeyword(Keyword keyword);
}
