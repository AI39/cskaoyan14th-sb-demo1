package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.*;
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

    @Autowired
    UserMapper userMapper;

    @Autowired
    GrouponMapper grouponMapper;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Autowired
    CouponUserMapper couponUserMapper;

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
    public ResponseVo<String> receiveCoupon(int userId,int couponId) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        CouponUser couponUser = new CouponUser();
        couponUser.setCouponId(couponId);
        couponUser.setUserId(userId);
        couponUser.setStatus(Short.valueOf("0"));
        int insert = couponUserMapper.insert(couponUser);
        if(insert==1){
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }
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
    public ResponseVo<PageData> getCouponList(int userId,short status, int page, int size) {

        PageHelper.startPage(page,size);
        CouponUserExample couponUserExample = new CouponUserExample();
        CouponUserExample.Criteria criteria = couponUserExample.createCriteria();

        criteria.andStatusEqualTo(status).andUserIdEqualTo(userId);
        List<CouponUser> couponUsers = couponUserMapper.selectByExample(couponUserExample);

        ArrayList<Coupon> list = new ArrayList<>();

        for (CouponUser items:couponUsers) {
            Integer couponId = items.getCouponId();
            Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
            list.add(coupon);
        }

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
    public ResponseVo<List> selectCouponList(int cartId, int grouponRulesId) {

        CouponExample couponExample = new CouponExample();
        CouponExample.Criteria criteria = couponExample.createCriteria();
        criteria.andStatusEqualTo(Short.valueOf("0"));

        List<Coupon> coupons = couponMapper.selectByExample(couponExample);
        ResponseVo<List> responseVo = new ResponseVo<>();

        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        responseVo.setData(coupons);

        return responseVo;
    }

    @Override
    public ResponseVo<PageData> getMyGroupon(int userId,int showType) {

        ResponseVo<PageData> responseVo = new ResponseVo<>();

        if(showType==0){
            ArrayList<MyGroupon> myGroupons = new ArrayList<>();
            List<Groupon> groupons=grouponMapper.selectByUserId(userId);

            for (Groupon groupon:groupons) {

                MyGroupon myGroupon = new MyGroupon();
                myGroupon.setOrderStatusText("已收货");
                User user = userMapper.selectByPrimaryKey(userId);
                myGroupon.setCreator(user.getNickname());
                myGroupon.setGroupon(groupon);

                Integer orderId = groupon.getOrderId();
                myGroupon.setOrderId(orderId);
                Order order = orderMapper.selectByPrimaryKey(orderId);

                String orderSn = order.getOrderSn();
                myGroupon.setOrderSn(orderSn);
                myGroupon.setActualPrice(order.getActualPrice());
                myGroupon.setJoinerCount(new Random().nextInt(10));
                ArrayList<Goods> goodsList = new ArrayList<>();
                myGroupon.setGoodsList(goodsList);
                Integer rulesId = groupon.getRulesId();

                GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(rulesId);
                myGroupon.setRules(grouponRules);
                myGroupon.setId(groupon.getId());
                myGroupon.setCreator(true);

                HandleOption handleOption = new HandleOption(false,true,false,true,false,false,true);
                myGroupon.setHandleOption(handleOption);
                myGroupons.add(myGroupon);
            }
            PageData<MyGroupon> pageData = new PageData<>(myGroupons,myGroupons.size());

            responseVo.setData(pageData);
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);

        } else if(showType==1){

            ArrayList<MyGroupon> myGroupons = new ArrayList<>();
            PageData<MyGroupon> pageData = new PageData<>(myGroupons,myGroupons.size());

            responseVo.setData(pageData);
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }
        return responseVo;
    }

    @Override
    public ResponseVo<GrouponDetail> getGrouponDetail(int grouponId) {

        GrouponDetail detail = new GrouponDetail();
        Groupon groupon = grouponMapper.selectByPrimaryKey(grouponId);

        Integer creatorUserId = groupon.getCreatorUserId();
        User user = userMapper.selectByPrimaryKey(creatorUserId);
        Creator creator = new Creator(user.getNickname(),"");
        detail.setCreator(creator);
        detail.setGroupon(groupon);
        Creator[] creators={creator};
        detail.setJoiners(creators);

        Integer orderId = groupon.getOrderId();
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderInfo orderInfo = new OrderInfo(order.getConsignee(),order.getAddress(),order.getAddTime(),order.getOrderSn(),order.getActualPrice(),order.getMobile(),order.getShipChannel(),
                "已收货",order.getGoodsPrice(),order.getShipSn(),orderId,order.getFreightPrice(),new HandleOption(false,true,false,true,false,false,true));

        detail.setOrderInfo(orderInfo);

        Integer rulesId = groupon.getRulesId();
        GrouponRules grouponRules = grouponRulesMapper.selectByPrimaryKey(rulesId);
        detail.setRules(grouponRules);
        detail.setLinkGrouponId(grouponId);
        ResponseVo<GrouponDetail> responseVo = new ResponseVo<>(0,detail,"成功");

        return responseVo;
    }


}
