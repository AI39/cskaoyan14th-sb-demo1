package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Collect;
import com.cskaoyan14th.vo.Page;

import java.util.Map;

public interface CollectService {
    Page<Collect> getPageList(int page, int limit, String sort, String order);

    Page<Collect> getPageList(int page, int limit, String userId, String valueId, String sort, String order);

    Map<String, Object> getCollectDataList(int page, int size, int userId, int type);

    String addordeleteCollect(int userId, int valueId);
}
