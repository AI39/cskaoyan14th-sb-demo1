package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Keyword;

import java.util.List;
import java.util.Map;

public interface SearchService {
    Keyword getDefaultKeyWord();

    List<Keyword> getHotKeywordList();

    List<Map<String, String>> getHistoryKeywordList(Integer userId);

    int clearHistoryByUserId(Integer userId);
}
