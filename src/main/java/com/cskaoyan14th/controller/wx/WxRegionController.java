package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Region;
import com.cskaoyan14th.service.RegionService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yuechao Yang
 * @version 2019-07-09-17:26
 */
@RestController
@RequestMapping("/wx/region")
public class WxRegionController {
    @Autowired
    RegionService regionService;
    @RequestMapping("list")
    public ResponseVo<List<Region>> regionList(){
        ResponseVo<List<Region>> responseVo = new ResponseVo<>();
        List<Region> regionList= regionService.queryRegionList();
        responseVo.setData(regionList);
        if (regionList != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else{
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }

}
