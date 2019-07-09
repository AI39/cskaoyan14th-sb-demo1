package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Brand;
import com.cskaoyan14th.service.BrandService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseMapVo;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yuechao Yang
 * @version 2019-07-09-11:04
 */
@RestController
@RequestMapping("/wx/brand")
public class WxBrandController {

    @Autowired
    BrandService brandService;
    @RequestMapping("list")
    @ResponseBody
    public ResponseMapVo queryBrandList(int page, int size){
        ResponseMapVo responseMapVo = new ResponseMapVo();
        Map<String, Object> data = new HashMap<>();
        List<Brand> WxBrandList = brandService.queryWxBrandList(page, size);
        data.put("brandList", WxBrandList);
        long count = brandService.queryCountBrand();
        int totalPages = (int)(count / size);
        if (count / size != 0){
            totalPages += 1;
        }
        data.put("totalPages", totalPages);
        if (data != null){
            responseMapVo.setData(data);
            responseMapVo.setErrno(0);
            responseMapVo.setErrmsg("成功");
        }else {
            responseMapVo.setErrno(404);
            responseMapVo.setErrmsg("失败");
        }
        return responseMapVo;
    }
    @RequestMapping("detail")
    @ResponseBody
    public ResponseVo<Brand> queryBrandDetail(int id){
        ResponseVo<Brand> responseVo = new ResponseVo<>();
        Brand brandDetail = brandService.queryBrandDetail(id);
        if (brandDetail != null){
            responseVo.setData(brandDetail);
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }else{
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }
}
