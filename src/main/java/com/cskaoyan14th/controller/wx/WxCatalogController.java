package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.WxCatalog;
import com.cskaoyan14th.service.CategoryService;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Yuechao Yang
 * @version 2019-07-08-20:03
 */
@Controller
@RequestMapping("/wx/catalog")
public class WxCatalogController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("index")
    @ResponseBody
    public ResponseVo<WxCatalog> catalogIndex(){
        ResponseVo<WxCatalog> responseVo = new ResponseVo<>();
        WxCatalog wxCatalogIndex = categoryService.queryCatalogIndex();
        if (wxCatalogIndex != null){
            responseVo.setData(wxCatalogIndex);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(404);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }
    @RequestMapping("current")
    @ResponseBody
    public ResponseVo<WxCatalog> currentCatalog(int id){
        ResponseVo<WxCatalog> responseVo = new ResponseVo<>();
        WxCatalog currentWxCatalog = categoryService.queryCurrentCatalog(id);
        if (currentWxCatalog != null){
            responseVo.setData(currentWxCatalog);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(404);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }
}
