package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Category;
import com.cskaoyan14th.bean.wx.Catalog;
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
    public ResponseVo<Catalog> catalogIndex(){
        ResponseVo<Catalog> responseVo = new ResponseVo<>();
        Catalog catalogIndex = categoryService.queryCatalogIndex();
        if (catalogIndex != null){
            responseVo.setData(catalogIndex);
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
    public ResponseVo<Catalog> currentCatalog(int id){
        ResponseVo<Catalog> responseVo = new ResponseVo<>();
        Catalog currentCatalog = categoryService.queryCurrentCatalog(id);
        if (currentCatalog != null){
            responseVo.setData(currentCatalog);
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrno(404);
            responseVo.setErrmsg("失败");
        }
        return responseVo;
    }
}
