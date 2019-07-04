package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Goods;
import com.cskaoyan14th.vo.Page;

import java.util.List;

public interface GoodsService {
    Page<Goods> getGoodsPage(int page, int limit, String sort, String order);
}
