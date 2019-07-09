package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Keyword;

import java.util.List;

public interface SearchService {
    Keyword getDefaultKeyWord();

    List<Keyword> getHotKeywordList();
}
