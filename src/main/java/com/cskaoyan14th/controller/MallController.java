package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Category;
import com.cskaoyan14th.bean.Issue;
import com.cskaoyan14th.bean.Region;
import com.cskaoyan14th.service.*;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
    public ResponseVo<Page<Issue>> issueList(int page, int limit){                                                  /*数据回显*/
        Page<Issue> issueList = issueService.queryIssueList(page, limit);                                           /*调用底层查询方法*/
        ResponseVo<Page<Issue>> responseVo = new ResponseVo<>();                                                    /*将其封装到json数据所需要的格式，共有三个变量*/
        if (issueList != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(issueList);
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }
    @RequestMapping("issue/update")
    @ResponseBody
    public ResponseVo<Issue> updateIssue(Date addTime, String answer, boolean deleted, Integer id, String question, Date updateTime){
        Issue issue = new Issue();
        issue.setAddTime(addTime);
        issue.setAnswer(answer);
        issue.setDeleted(deleted);
        issue.setId(id);
        issue.setQuestion(question);
        issue.setUpdateTime(updateTime);
        System.out.println(issue + "111");
        ResponseVo<Issue> responseVo = new ResponseVo<>();
        Issue update = issueService.updateIssue(issue);
        responseVo.setData(update);
        if ( update != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");

        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }
}
