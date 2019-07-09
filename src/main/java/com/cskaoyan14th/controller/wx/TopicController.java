package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.CommentList;
import com.cskaoyan14th.bean.Topic;
import com.cskaoyan14th.service.AdService;
import com.cskaoyan14th.service.TopicService;
import com.cskaoyan14th.vo.PageData;
import com.cskaoyan14th.vo.ResponseVo;
import com.cskaoyan14th.vo.TopicDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public ResponseVo<String> receiveCoupon(@RequestBody Map<String,Integer> map){
        Integer couponId=map.get("couponId");
        ResponseVo<String> responseVo=topicService.receiveCoupon(couponId);
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
    public ResponseVo<PageData> getCouponList(int status,int page,int size){
        ResponseVo<PageData> responseVo=topicService.getCouponList(status,page,size);
        return responseVo;
    }

    @RequestMapping("coupon/exchange")
    @ResponseBody
    public ResponseVo<String> exchange(@RequestBody Map<String,String> map){
        String code = map.get("code");
        ResponseVo<String> responseVo=topicService.exchange(code);
        return responseVo;
    }





}
