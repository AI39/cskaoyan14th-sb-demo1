package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Collect;
import com.cskaoyan14th.bean.Feedback;
import com.cskaoyan14th.bean.SearchHistory;
import com.cskaoyan14th.mapper.FeedbackMapper;
import com.cskaoyan14th.service.FeedbackService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackMapper feedbackMapper;
    @Override
    public Page<Feedback> getPageList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Feedback> feedbacks = feedbackMapper.selectFeedbackListOrder(sort, order);
        PageInfo<Feedback> pageInfo = new PageInfo<>(feedbacks);
        Page<Feedback> feedbackList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        return feedbackList;
    }

    @Override
    public Page<Feedback> getPageList(int page, int limit, String username, String id, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Feedback> feedbacks = feedbackMapper.selectFeedbackListOrder(username,id,sort, order);
        PageInfo<Feedback> pageInfo = new PageInfo<>(feedbacks);
        Page<Feedback> feedbackList = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        return feedbackList;
    }


}
