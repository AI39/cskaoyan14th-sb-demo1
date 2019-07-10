package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Footprint;
import com.cskaoyan14th.vo.Page;

import java.util.List;

public interface FootprintService {
    Page<Footprint> getPageList(int page, int limit, String sort, String order);

    Page<Footprint> getPageList(int page, int limit, String userId, String goodsId, String sort, String order);


    List<Footprint> queryFootprintList(Integer page, Integer size);

    int queryFootprintTotalPages(Integer page, Integer size);
}
