package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.CommentList;
import com.cskaoyan14th.bean.GrouponDetail;
import com.cskaoyan14th.bean.GrouponRules;
import com.cskaoyan14th.bean.Topic;
import com.cskaoyan14th.service.AdService;
import com.cskaoyan14th.service.TopicService;
import com.cskaoyan14th.util.UserTokenManager;
import com.cskaoyan14th.vo.PageData;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.TopicDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/wx")
public class TopicController {

    @Autowired
    TopicService topicService;


    @RequestMapping("topic/list")
    @ResponseBody
    public ResponseVo<PageData> getTopicListWx(int page,int size){
        ResponseVo<PageData> responseVo=topicService.getTopicListWx(page,size);
        return responseVo;
    }

    @RequestMapping("topic/detail")
    @ResponseBody
    public ResponseVo<TopicDetail> getTopicDetail(int id){
        ResponseVo<TopicDetail> responseVo= topicService.getTopicDetail(id);
        return responseVo;
    }

    @RequestMapping("topic/related")
    @ResponseBody
    public ResponseVo<List> getRelatedTopic(int id){
        ResponseVo<List> responseVo=topicService.getRelatedTopic(id);
        return responseVo;
    }


    @RequestMapping("coupon/receive")
    @ResponseBody
    public ResponseVo<String> receiveCoupon(HttpServletRequest request,@RequestBody Map<String,Integer> map){
        //获取userId
        String token = request.getHeader("X-Litemall-Token");
        Integer userId= UserTokenManager.getUserId(token);

        Integer couponId=map.get("couponId");
        ResponseVo<String> responseVo=topicService.receiveCoupon(userId,couponId);
        return responseVo;
    }

    @RequestMapping("coupon/list")
    @ResponseBody
    public ResponseVo<PageData> getCouponListAll(int page,int size){
        ResponseVo<PageData> responseVo=topicService.getCouponListAll(page,size);
        return responseVo;
    }

    @RequestMapping("groupon/list")
    @ResponseBody
    public ResponseVo<PageData> getGrouponxListAll(int page,int size){
        ResponseVo<PageData> responseVo=topicService.getGrouponxListAll(page,size);
        return responseVo;
    }

    @RequestMapping("coupon/mylist")
    @ResponseBody
    public ResponseVo<PageData> getCouponList(HttpServletRequest request,short status,int page,int size){
        //获取userId
        String token = request.getHeader("X-Litemall-Token");
        Integer userId= UserTokenManager.getUserId(token);
        ResponseVo<PageData> responseVo=topicService.getCouponList(userId,status,page,size);
        return responseVo;
    }

    @RequestMapping("coupon/exchange")
    @ResponseBody
    public ResponseVo<String> exchange(@RequestBody Map<String,String> map){
        String code = map.get("code");
        ResponseVo<String> responseVo=topicService.exchange(code);
        return responseVo;
    }

    /*
    cartId=193&grouponRulesId=0
     */
    @RequestMapping("coupon/selectlist")
    @ResponseBody
    public ResponseVo<List> selectCouponList(int cartId, int grouponRulesId){
        ResponseVo<List> responseVo=topicService.selectCouponList(cartId,grouponRulesId);
        return responseVo;
    }

    @RequestMapping("groupon/my")
    @ResponseBody
    public ResponseVo<PageData> getMyGroupon(HttpServletRequest request,int showType){
        //获取userId
        String token = request.getHeader("X-Litemall-Token");
        Integer userId= UserTokenManager.getUserId(token);

        ResponseVo<PageData> responseVo=topicService.getMyGroupon(userId,showType);
        return responseVo;
    }

    @RequestMapping("groupon/detail")
    @ResponseBody
    public ResponseVo<GrouponDetail> getGrouponDetail(int grouponId){
        ResponseVo<GrouponDetail> responseVo=topicService.getGrouponDetail(grouponId);
        return responseVo;
    }





}
