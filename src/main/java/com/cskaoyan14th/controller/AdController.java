package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.AdService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AdController {

    @Autowired
    AdService adService;

    @RequestMapping("ad/list")
    @ResponseBody
    public ResponseVo<Page> getAdList(int page, int limit,String name,String content,String sort,String order){
        if(name==null&&content==null){
            ResponseVo<Page> responseVo = adService.getAdList(page, limit, sort, order);
            return responseVo;
        } else if(name!=null&&content==null){
            ResponseVo<Page> responseVo = adService.searchAd(page, limit,name, sort, order);
            return responseVo;
        } else{
            ResponseVo<Page> responseVo = adService.searchAd(page, limit,name,content, sort, order);
            return responseVo;
        }
    }

    @RequestMapping("ad/update")
    @ResponseBody
    public ResponseVo<Ad> editAd(@RequestBody Ad ad){
        ResponseVo<Ad> responseVo = adService.editAd(ad);
        return responseVo;
    }

    @RequestMapping("ad/delete")
    @ResponseBody
    public ResponseVo<String> deleteAd(@RequestBody Ad ad){
        ResponseVo<String> responseVo=adService.deleteAd(ad);
        return responseVo;
    }

   /* @RequestMapping("admin/storage/create")
    @ResponseBody
    public ResponseVo<Storage> createPic(){
        
    }*/

    @RequestMapping("ad/create")
    @ResponseBody
    public ResponseVo<Ad> createAd(@RequestBody Ad ad){
       ResponseVo<Ad> responseVo = adService.insertAd(ad);
       return responseVo;
    }

    @RequestMapping("coupon/list")
    @ResponseBody
    public ResponseVo<Page> getCouponList(int page, int limit,String name,Short type,Short status,String sort,String order){
        if(name==null&&type==null&&status==null){
            ResponseVo<Page> couponList = adService.getCouponList(page, limit, sort, order);
            return couponList;
        } else if(name!=null&&type==null&&status==null){
            ResponseVo<Page> couponList = adService.getCouponList(page, limit, name, sort, order);
            return couponList;
        } else if(name==null&&type!=null&&status==null){
            ResponseVo<Page> couponListByType = adService.getCouponListByType(page, limit, type, sort, order);
            return couponListByType;
        } else if(name==null&&type==null&&status!=null){
            ResponseVo<Page> couponListByStatus = adService.getCouponListByStatus(page, limit, status, sort, order);
            return couponListByStatus;
        } else if(name!=null&&type!=null&&status==null){
            ResponseVo<Page> couponListByNameAndType = adService.getCouponListByNameAndType(page,limit,name,type,sort,order);
            return couponListByNameAndType;
        } else if(name!=null&&type==null&&status!=null){
            ResponseVo<Page> couponListByNameAndStatus = adService.getCouponListByNameAndStatus(page,limit,name,status,sort,order);
            return couponListByNameAndStatus;
        } else if (name==null&&type!=null&&status!=null){
            ResponseVo<Page> couponListByTypeAndStatus = adService.getCouponListByTypeAndStatus(page, limit, type, status, sort, order);
            return couponListByTypeAndStatus;

        }
        ResponseVo<Page> responseVo = adService.getCouponList(page, limit,name,type,status, sort, order);
        return responseVo;
    }

    @RequestMapping("coupon/update")
    @ResponseBody
    public ResponseVo<Coupon> editCoupon(@RequestBody Coupon coupon){
        ResponseVo<Coupon> responseVo = adService.editCoupon(coupon);
        return responseVo;
    }

    @RequestMapping("coupon/delete")
    @ResponseBody
    public ResponseVo<String> deleteCoupon(@RequestBody Coupon coupon){
        ResponseVo<String> responseVo=adService.deleteCoupon(coupon);
        return responseVo;
    }

    @RequestMapping("topic/list")
    @ResponseBody
    public ResponseVo<Page> getTopicList(int page,int limit,String title,String subtitle,String sort,String order){
        if(title==null&&subtitle==null){
            ResponseVo<Page> responseVo=adService.getTopicList(page,limit,sort,order);
            return responseVo;
        } else if(title!=null&&subtitle==null){
            ResponseVo<Page> responseVo=adService.getTopicListByTitle(page,limit,title,sort,order);
            return responseVo;
        } else if(title==null&&subtitle!=null){
            ResponseVo<Page> responseVo=adService.getTopicListBySubtitle(page,limit,subtitle,sort,order);
            return responseVo;
        }
        ResponseVo<Page> responseVo=adService.getTopicList(page,limit,title,subtitle,sort,order);
        return responseVo;
    }

    @RequestMapping("topic/update")
    @ResponseBody
    public ResponseVo<Topic> editTopic(@RequestBody Topic topic){
        ResponseVo<Topic> responseVo = adService.editTopic(topic);
        return responseVo;
    }

    @RequestMapping("topic/delete")
    @ResponseBody
    public ResponseVo<String> deleteTopic(@RequestBody Topic topic){
        ResponseVo<String> responseVo = adService.deleteTopic(topic);
        return responseVo;
    }

    @RequestMapping("groupon/list")
    @ResponseBody
    public ResponseVo<Page> getGrouponList(int page,int limit,Integer goodsId,String sort,String order){
        if(goodsId==null){
            ResponseVo<Page> responseVo=adService.getGrouponList(page,limit,sort,order);
            return responseVo;
        }
        ResponseVo<Page> responseVo=adService.getGrouponListByGoodsid(page,limit,goodsId,sort,order);
        return responseVo;
    }

    @RequestMapping("groupon/update")
    @ResponseBody
    public ResponseVo<String> editGrouponRules(@RequestBody GrouponRules grouponRules){
        ResponseVo<String> responseVo = adService.editGrouponRules(grouponRules);
        return responseVo;
    }

    @RequestMapping("groupon/delete")
    @ResponseBody
    public ResponseVo<String> deleteGrouponRules(@RequestBody GrouponRules grouponRules){
        ResponseVo<String> responseVo = adService.deleteGrouponRules(grouponRules);
        return responseVo;
    }

    @RequestMapping("groupon/listRecord")
    @ResponseBody
    public ResponseVo<Page> getGrouponActivityList(int page,int limit,Integer goodsId,String sort,String order){
            ResponseVo<Page> responseVo=adService.getGrouponActivityList(page,limit,sort,order);
            return responseVo;
    }




}
