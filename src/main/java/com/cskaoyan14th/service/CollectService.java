package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Collect;
import com.cskaoyan14th.vo.Page;

public interface CollectService {
    Page<Collect> getPageList(int page, int limit, String sort, String order);

    Page<Collect> getPageList(int page, int limit, String userId, String valueId, String sort, String order);
}
