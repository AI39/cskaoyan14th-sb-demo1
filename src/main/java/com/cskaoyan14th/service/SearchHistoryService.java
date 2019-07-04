package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.SearchHistory;
import com.cskaoyan14th.vo.Page;

public interface SearchHistoryService {
    Page<SearchHistory> getPageList(int page, int limit, String sort, String order);

    Page<SearchHistory> getPageList(int page, int limit, String userId, String keyword, String sort, String order);
}
