package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Footprint;
import com.cskaoyan14th.vo.Page;

public interface FootprintService {
    Page<Footprint> getPageList(int page, int limit, String sort, String order);
}
