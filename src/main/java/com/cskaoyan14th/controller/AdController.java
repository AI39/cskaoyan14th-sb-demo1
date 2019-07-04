package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Ad;
import com.cskaoyan14th.bean.Storage;
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
    public ResponseVo<Page> getAdList(int page, int limit,String sort,String order){
        ResponseVo<Page> responseVo = adService.getAdList(page, limit, sort, order);
        return responseVo;
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


}
