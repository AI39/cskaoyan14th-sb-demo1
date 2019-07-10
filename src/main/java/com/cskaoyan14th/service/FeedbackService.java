package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Feedback;
import com.cskaoyan14th.vo.Page;

import java.util.Map;

public interface FeedbackService {
    Page<Feedback> getPageList(int page, int limit, String sort, String order);

    Page<Feedback> getPageList(int page, int limit, String username, String id, String sort, String order);

    int  insertSelective(Feedback record);


}
