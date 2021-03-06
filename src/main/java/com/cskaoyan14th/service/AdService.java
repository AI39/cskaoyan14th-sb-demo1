package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;

import java.util.List;

public interface AdService {

    List<Ad> getAdAll();

    ResponseVo<Page> getAdList(int page, int limit, String sort, String order);

    ResponseVo<Ad> editAd(Ad ad);

    ResponseVo<String> deleteAd(Ad ad);

    ResponseVo<Ad> insertAd(Ad ad);

    ResponseVo<Page> searchAd(int page, int limit,String name,String sort,String order);

    ResponseVo<Page> searchAd(int page, int limit,String name,String content, String sort,String order);

    List<Coupon> getCouponAll();

    ResponseVo<Page> getCouponList(int page, int limit, String sort, String order);

    ResponseVo<Page> getCouponList(int page, int limit,String name, String sort, String order);

    ResponseVo<Page> getCouponList(int page, int limit,String name,short type,short status, String sort, String order);

    ResponseVo<Coupon> readCoupon(int id);

    ResponseVo<Coupon> insertCoupon(Coupon coupon);

    ResponseVo<Coupon> editCoupon(Coupon coupon);

    ResponseVo<String> deleteCoupon(Coupon coupon);

    ResponseVo<Page> getCouponListByType(int page, int limit,short type, String sort, String order);

    ResponseVo<Page> getCouponListByStatus(int page, int limit,short status, String sort, String order);

    ResponseVo<Page> getCouponListByNameAndType(int page, int limit,String name,short type,String sort, String order);


    ResponseVo<Page> getCouponListByNameAndStatus(int page, int limit,String name,short status,String sort, String order);

    ResponseVo<Page> getCouponListByTypeAndStatus(int page, int limit,short type,short status,String sort, String order);

    List<Topic> getTopicAll();

    ResponseVo<Page> getTopicList(int page, int limit,String sort,String order);

    ResponseVo<Page> getTopicList(int page, int limit,String title,String subtitle,String sort,String order);

    ResponseVo<Topic> editTopic(Topic topic);

    ResponseVo<Topic> insertTopic(Topic topic);

    ResponseVo<String> deleteTopic(Topic topic);

    ResponseVo<Page> getTopicListByTitle(int page, int limit,String title,String sort,String order);

    ResponseVo<Page> getTopicListBySubtitle(int page, int limit,String subtitle,String sort,String order);

    ResponseVo<Page> getGrouponList(int page,int limit,String sort,String order);

    ResponseVo<GrouponRules> insertGrouponRules(GrouponRules grouponRules);

    ResponseVo<String> editGrouponRules(GrouponRules grouponRules);

    ResponseVo<String> deleteGrouponRules(GrouponRules grouponRules);

    ResponseVo<Page> getGrouponListByGoodsid(int page,int limit,int goodsId,String sort,String order);

    ResponseVo<Page> getGrouponActivityList(int page,int limit,String sort,String order);

    List<Grouponx> selectGrouponxLimit();
}
