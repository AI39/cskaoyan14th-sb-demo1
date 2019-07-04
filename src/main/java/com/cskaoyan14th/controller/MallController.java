package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Category;
import com.cskaoyan14th.bean.Issue;
import com.cskaoyan14th.bean.Region;
import com.cskaoyan14th.service.*;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseVo<Page<Issue>> issueList(int page, int limit, String question, String sort, String order){                                                  //数据回显
        Page<Issue> issueList = issueService.queryIssueList(page, limit, question, sort, order);                                           //调用底层查询方法
        ResponseVo<Page<Issue>> responseVo = new ResponseVo<>();                                                    //将其封装到json数据所需要的格式，共有三个变量
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
    public ResponseVo<Issue> updateIssue(@RequestBody Issue issue){                                                 //编辑，必须加上@RequestBody
                                                                                                                    //疑问，什么时候用requestBody？
        System.out.println(issue);                                                                                  //@RequestBody主要用来接收前端传递给后端的json字符串中的数据的(请求体中的数据的)；GET方式无请求体，所以使用@RequestBody接收数据时，前端不能使用GET方式提交数据，而是用POST方式进行提交。在后端的同一个接收方法里，@RequestBody与@RequestParam()可以同时使用，@RequestBody最多只能有一个，而@RequestParam()可以有多个。
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
    @RequestMapping("issue/delete")
    @ResponseBody
    public ResponseVo<Issue> deleteIssue(@RequestBody Issue issue){
        ResponseVo<Issue> responseVo = new ResponseVo<>();
        int delete = issueService.deleteIssue(issue);
        if ( delete != 0){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(500);
        }
        return responseVo;
    }
    @RequestMapping("issue/create")
    @ResponseBody
    public ResponseVo<Issue> createIssue(@RequestBody Issue issue){
        ResponseVo<Issue> responseVo = new ResponseVo<>();
        Issue create = issueService.createIssue(issue);
        responseVo.setData(create);
        if ( create != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");

        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;

    }

}
