package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Category;
import com.cskaoyan14th.bean.Issue;
import com.cskaoyan14th.bean.Region;
import com.cskaoyan14th.service.*;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Yuechao Yang
 * @version 2019-07-03-21:08
 */
@RestController
public class MallController {
    @Autowired
    RegionService regionService;
    @Autowired
    BrandService brandService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    OrderService orderService;
    @Autowired
    IssueService issueService;
    @Autowired
    KeywordService keywordService;
    /*行政区域*/
   /* @RequestMapping("region/list")
    @ResponseBody
   public ResponseVo<Page<>> regionList(int page, int limit){
        regionService.queryRegionList(page, limit);
    }*/
   /*通用问题*/
    @RequestMapping("issue/list")
    @ResponseBody
    public ResponseVo<Page<Issue>> issueList(int page, int limit){
        Page<Issue> issueList = issueService.queryIssueList(page, limit);
        ResponseVo<Page<Issue>> responseVo = new ResponseVo<>();
        if (issueList != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(issueList);
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(400);
        }
        return responseVo;
    }
}
