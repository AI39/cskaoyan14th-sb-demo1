package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.mapper.*;
import com.cskaoyan14th.service.AdService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdMapper adMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    TopicMapper topicMapper;

    @Autowired
    GrouponRulesMapper grouponRulesMapper;

    @Autowired
    GrouponMapper grouponMapper;

    @Autowired
    GrouponActivityMapper grouponActivityMapper;

    @Override
    public ResponseVo<Page> getAdList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        AdExample adExample = new AdExample();
        AdExample.Criteria criteria = adExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Ad> ads = adMapper.selectByExample(adExample);
        PageInfo<Ad> pageInfo=new PageInfo<>(ads);
        Page<Ad> adPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,adPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Ad> editAd(Ad ad) {
        ResponseVo<Ad> adResponseVo = new ResponseVo<>();
        int i = adMapper.updateByPrimaryKey(ad);
        if(i==1){
            adResponseVo.setErrno(0);
            adResponseVo.setErrmsg("成功");
            adResponseVo.setData(ad);
        }
        return adResponseVo;
    }

    @Override
    public ResponseVo<String> deleteAd(Ad ad) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        int i = adMapper.deleteByPrimaryKey(ad.getId());
        if(i==1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

    @Override
    public ResponseVo<Ad> insertAd(Ad ad) {
        ResponseVo<Ad> responseVo = new ResponseVo<>();
        int insert = adMapper.insert(ad);
        if(insert==1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(ad);
        }
        return responseVo;
    }

    @Override
    public ResponseVo<Page> searchAd(int page, int limit, String name, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Ad> ads = adMapper.selectByName("%"+name+"%");
        PageInfo<Ad> pageInfo = new PageInfo<>(ads);
        Page<Ad> adPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,adPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> searchAd(int page, int limit, String name, String content, String sort, String order) {
        PageHelper.startPage(page,limit);
        if(name==null){
            List<Ad> ads = adMapper.selectByContent("%"+content+"%");
            PageInfo<Ad> pageInfo = new PageInfo<>(ads);
            Page<Ad> adPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
            ResponseVo<Page> responseVo = new ResponseVo<>(0,adPage,"成功");
            return responseVo;
        }
        List<Ad> ads = adMapper.selectByNameAndContent("%"+name+"%","%"+content+"%");
        PageInfo<Ad> pageInfo = new PageInfo<>(ads);
        Page<Ad> adPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,adPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getCouponList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Coupon> list = couponMapper.selectAllCoupon();
        PageInfo<Coupon> pageInfo=new PageInfo<>(list);
        Page<Coupon> couponPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,couponPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getCouponList(int page, int limit, String name, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Coupon> list = couponMapper.selectCouponByName("%"+name+"%");
        PageInfo<Coupon> pageInfo=new PageInfo<>(list);
        Page<Coupon> couponPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,couponPage,"成功");
        return responseVo;
    }



    @Override
    public ResponseVo<Page> getCouponList(int page, int limit,String name,short type,short status, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Coupon> list = couponMapper.selectSomeCoupon("%"+name+"%",type,status);
        PageInfo<Coupon> pageInfo=new PageInfo<>(list);
        Page<Coupon> couponPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,couponPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Coupon> editCoupon(Coupon coupon) {
        ResponseVo<Coupon> couponResponseVo = new ResponseVo<>();
        int i = couponMapper.updateByPrimaryKey(coupon);
        if(i==1){
            couponResponseVo.setErrno(0);
            couponResponseVo.setErrmsg("成功");
            couponResponseVo.setData(coupon);
        }
        return couponResponseVo;
    }

    @Override
    public ResponseVo<String> deleteCoupon(Coupon coupon) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        int i = couponMapper.deleteByPrimaryKey(coupon.getId());
        if(i==1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getCouponListByType(int page, int limit, short type, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Coupon> list = couponMapper.selectCouponByType(type);
        PageInfo<Coupon> pageInfo=new PageInfo<>(list);
        Page<Coupon> couponPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,couponPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getCouponListByStatus(int page, int limit, short status, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Coupon> list = couponMapper.selectCouponByStatus(status);
        PageInfo<Coupon> pageInfo=new PageInfo<>(list);
        Page<Coupon> couponPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,couponPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getCouponListByNameAndType(int page, int limit, String name, short type, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Coupon> list = couponMapper.selectCouponByNameAndType("%"+name+"%",type);
        PageInfo<Coupon> pageInfo=new PageInfo<>(list);
        Page<Coupon> couponPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,couponPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getCouponListByNameAndStatus(int page, int limit, String name, short status, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Coupon> list = couponMapper.selectCouponByNameAndStatus("%"+name+"%",status);
        PageInfo<Coupon> pageInfo=new PageInfo<>(list);
        Page<Coupon> couponPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,couponPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getCouponListByTypeAndStatus(int page, int limit, short type, short status, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<Coupon> list = couponMapper.selectCouponByTypeAndStatus(type,status);
        PageInfo<Coupon> pageInfo=new PageInfo<>(list);
        Page<Coupon> couponPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,couponPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getTopicList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        TopicExample topicExample = new TopicExample();
        TopicExample.Criteria criteria = topicExample.createCriteria();
        criteria.andIdIsNotNull();
        List<Topic> list = topicMapper.selectByExample(topicExample);
        PageInfo<Topic> pageInfo=new PageInfo<>(list);
        Page<Topic> topicPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,topicPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getTopicList(int page, int limit, String title, String subtitle, String sort, String order) {
        PageHelper.startPage(page,limit);
        /*TopicExample topicExample = new TopicExample();
        TopicExample.Criteria criteria = topicExample.createCriteria();
        criteria.andTitleLike(title).andSubtitleLike(subtitle);
        List<Topic> list = topicMapper.selectByExample(topicExample);*/
         List<Topic> list = topicMapper.selectByTitleAndSubtitle("%"+title+"%","%"+subtitle+"%");
        PageInfo<Topic> pageInfo=new PageInfo<>(list);
        Page<Topic> topicPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,topicPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Topic> editTopic(Topic topic) {
        ResponseVo<Topic> responseVo = new ResponseVo<>();
        int i = topicMapper.updateByPrimaryKey(topic);
        if(i==1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(topic);
        }
        return responseVo;
    }

    @Override
    public ResponseVo<String> deleteTopic(Topic topic) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        int i = topicMapper.deleteByPrimaryKey(topic.getId());
        if(i==1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getTopicListByTitle(int page, int limit, String title, String sort, String order) {
        PageHelper.startPage(page,limit);
        /*TopicExample topicExample = new TopicExample();
        TopicExample.Criteria criteria = topicExample.createCriteria();
        criteria.andTitleLike(title);
        List<Topic> list = topicMapper.selectByExample(topicExample);*/
        List<Topic> list = topicMapper.selectByTitle("%"+title+"%");
        PageInfo<Topic> pageInfo=new PageInfo<>(list);
        Page<Topic> topicPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,topicPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getTopicListBySubtitle(int page, int limit, String subtitle, String sort, String order) {
        PageHelper.startPage(page,limit);
        /*TopicExample topicExample = new TopicExample();
        TopicExample.Criteria criteria = topicExample.createCriteria();
        criteria.andSubtitleLike(subtitle);
        List<Topic> list = topicMapper.selectByExample(topicExample);*/
        List<Topic> list = topicMapper.selectBySubtitle("%"+subtitle+"%");
        PageInfo<Topic> pageInfo=new PageInfo<>(list);
        Page<Topic> topicPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,topicPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getGrouponList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        GrouponRulesExample grouponRulesExample = new GrouponRulesExample();
        GrouponRulesExample.Criteria criteria = grouponRulesExample.createCriteria();
        criteria.andIdIsNotNull();
        List<GrouponRules> list = grouponRulesMapper.selectByExample(grouponRulesExample);
        PageInfo<GrouponRules> pageInfo=new PageInfo<>(list);
        Page<GrouponRules> grouponRulesPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,grouponRulesPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<String> editGrouponRules(GrouponRules grouponRules) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        int i = grouponRulesMapper.updateByPrimaryKey(grouponRules);
        if(i==1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

    @Override
    public ResponseVo<String> deleteGrouponRules(GrouponRules grouponRules) {
        ResponseVo<String> responseVo = new ResponseVo<>();
        int i = grouponRulesMapper.deleteByPrimaryKey(grouponRules.getId());
        if(i==1){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getGrouponListByGoodsid(int page, int limit, int goodsId, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<GrouponRules> list = grouponRulesMapper.selectByGoodsid(goodsId);
        PageInfo<GrouponRules> pageInfo=new PageInfo<>(list);
        Page<GrouponRules> grouponRulesPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,grouponRulesPage,"成功");
        return responseVo;
    }

    @Override
    public ResponseVo<Page> getGrouponActivityList(int page, int limit, String sort, String order) {
        PageHelper.startPage(page,limit);
        List<GrouponActivity> list=grouponActivityMapper.selectAll();
        PageInfo<GrouponActivity> pageInfo=new PageInfo<>(list);
        Page<GrouponActivity> grouponActivityPage = new Page<>(pageInfo.getList(),(int)pageInfo.getTotal());
        ResponseVo<Page> responseVo = new ResponseVo<>(0,grouponActivityPage,"成功");
        return responseVo;
    }



}
