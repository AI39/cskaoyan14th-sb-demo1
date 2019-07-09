package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.CommentMapper;
import com.cskaoyan14th.mapper.CouponMapper;
import com.cskaoyan14th.mapper.GrouponxMapper;
import com.cskaoyan14th.mapper.TopicMapper;
import com.cskaoyan14th.service.TopicService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.PageData;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.TopicDetail;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicMapper topicMapper;

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    GrouponxMapper grouponxMapper;

    @Autowired
    AdServiceImpl adService;

    @Override
    public ResponseVo<PageData> getTopicListWx(int page, int size) {
        PageHelper.startPage(page,size);
        TopicExample topicExample = new TopicExample();
        TopicExample.Criteria criteria = topicExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Topic> list = topicMapper.selectByExample(topicExample);
        PageInfo<Topic> pageInfo=new PageInfo<>(list);
        PageData<Topic> topicPage = new PageData<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<PageData> responseVo = new ResponseVo<>(0,topicPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<TopicDetail> getTopicDetail(int id) {
        Topic topic = topicMapper.selectByPrimaryKey(id);
        String[] goods=null;
        TopicDetail topicDetail = new TopicDetail(topic,goods);
        ResponseVo<TopicDetail> responseVo = new ResponseVo<>(0,topicDetail,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<List> getRelatedTopic(int id) {
        List<Topic> list=topicMapper.selectRelatedTopic(id);
        ResponseVo<List> responseVo = new ResponseVo<>(0,list,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<CommentList> getCommentList(int valueId, int type, int showType, int page, int size) {
        /*PageHelper.startPage(page,size);
        CommentExample commentExample = new CommentExample();
        CommentExample.Criteria criteria = commentExample.createCriteria();
        criteria.andValueIdEqualTo(valueId);
        List<Comment> comments = commentMapper.selectByExample(commentExample);*/
        CommentList commentList = new CommentList();
       /* commentList.setData(null);*/
        commentList.setCount(0);
        commentList.setCurrentPage(1);
        ResponseVo<CommentList> responseVo = new ResponseVo<>();
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        responseVo.setData(commentList);
        return responseVo;
    }

    @Override
    public ResponseVo<String> receiveCoupon(int couponId) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

    @Override
    public ResponseVo<PageData> getCouponListAll(int page, int size) {
        PageHelper.startPage(page,size);
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        PageInfo<Coupon> pageInfo=new PageInfo<>(coupons);
        PageData<Coupon> couponPageData = new PageData<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<PageData> responseVo = new ResponseVo<>(0,couponPageData,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<PageData> getGrouponxListAll(int page, int size) {
        PageHelper.startPage(page,size);
        List<Grouponx> grouponxes = adService.selectGrouponxLimit();
        PageInfo<Grouponx> pageInfo=new PageInfo<>(grouponxes);
        PageData<Grouponx> pageData = new PageData<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<PageData> responseVo = new ResponseVo<>(0,pageData,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<PageData> getCouponList(int status, int page, int size) {
        if(status==0){
            PageHelper.startPage(page,size);
            List<Coupon> list=new ArrayList<>();
            Coupon coupon1 = couponMapper.selectByPrimaryKey(2);
            Coupon coupon2 = couponMapper.selectByPrimaryKey(3);
            list.add(coupon1);
            list.add(coupon2);
            PageInfo<Coupon> pageInfo=new PageInfo<>(list);
            PageData<Coupon> couponPageData = new PageData<>(pageInfo.getList(),(int)pageInfo.getTotal());
            ResponseVo<PageData> responseVo = new ResponseVo<>(0,couponPageData,"成功");
            return responseVo;

        }else if(status==1){
            PageHelper.startPage(page,size);
            List<Coupon> list=new ArrayList<>();
            Coupon coupon1 = couponMapper.selectByPrimaryKey(8);
            Coupon coupon2 = couponMapper.selectByPrimaryKey(9);
            list.add(coupon1);
            list.add(coupon2);
            PageInfo<Coupon> pageInfo=new PageInfo<>(list);
            PageData<Coupon> couponPageData = new PageData<>(pageInfo.getList(),(int)pageInfo.getTotal());
            ResponseVo<PageData> responseVo = new ResponseVo<>(0,couponPageData,"成功");
            return responseVo;
        } else if(status==2){
            PageHelper.startPage(page,size);
            List<Coupon> list=new ArrayList<>();
            Coupon coupon2 = couponMapper.selectByPrimaryKey(9);
            list.add(coupon2);
            PageInfo<Coupon> pageInfo=new PageInfo<>(list);
            PageData<Coupon> couponPageData = new PageData<>(pageInfo.getList(),(int)pageInfo.getTotal());
            ResponseVo<PageData> responseVo = new ResponseVo<>(0,couponPageData,"成功");
            return responseVo;
        }
        PageHelper.startPage(page,size);
        List<Coupon> list=new ArrayList<>();
        Coupon coupon2 = couponMapper.selectByPrimaryKey(9);
        list.add(coupon2);
        PageInfo<Coupon> pageInfo=new PageInfo<>(list);
        PageData<Coupon> couponPageData = new PageData<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<PageData> responseVo = new ResponseVo<>(0,couponPageData,"成功");
        return responseVo;

    }

    @Override
    public ResponseVo<String> exchange(String code) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        Coupon coupon=couponMapper.selectCouponByCode(code);
        if(coupon==null){
            responseVo.setErrno(742);
            responseVo.setErrmsg("优惠券不正确");
            return responseVo;
        }
        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");
        return responseVo;
    }

    @Override
    public ResponseVo<List> selectCouponList(int cartId, int grouponRules) {
        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        ResponseVo<List> responseVo = new ResponseVo<>();
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        responseVo.setData(coupons);
        return responseVo;
    }


}
