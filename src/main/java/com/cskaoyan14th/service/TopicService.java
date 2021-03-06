package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.CommentList;
import com.cskaoyan14th.bean.GrouponDetail;
import com.cskaoyan14th.bean.GrouponRules;
import com.cskaoyan14th.bean.Topic;
import com.cskaoyan14th.vo.PageData;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.TopicDetail;

import java.util.List;

public interface TopicService {
    ResponseVo<PageData> getTopicListWx(int page,int size);

    ResponseVo<TopicDetail> getTopicDetail(int id);

    ResponseVo<List> getRelatedTopic(int id);

    ResponseVo<CommentList> getCommentList(int valueId,int type,int showType,int page,int size);

    ResponseVo<String> receiveCoupon(int userId,int couponId);

    ResponseVo<PageData> getCouponListAll(int page,int size);

    ResponseVo<PageData> getGrouponxListAll(int page,int size);

    ResponseVo<PageData> getCouponList(int userId,short status,int page,int size);

    ResponseVo<String> exchange(String code);

    ResponseVo<List> selectCouponList(int cartId, int grouponRulesId);

    ResponseVo<PageData> getMyGroupon(int userId,int showType);

    ResponseVo<GrouponDetail> getGrouponDetail(int grouponId);
}
