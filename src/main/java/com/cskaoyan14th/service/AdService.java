package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Ad;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;

public interface AdService {
    ResponseVo<Page> getAdList(int page, int limit, String sort, String order);

    ResponseVo<Ad> editAd(Ad ad);

    ResponseVo<String> deleteAd(Ad ad);

    ResponseVo<Ad> insertAd(Ad ad);
}
