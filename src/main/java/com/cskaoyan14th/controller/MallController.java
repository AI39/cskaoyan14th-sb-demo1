package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.*;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.System;
import java.util.Date;
import java.util.List;

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
    @RequestMapping("region/list")
    @ResponseBody
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


   /*通用问题，共有四个方法实现*/
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


    /*关键词,共有四个方法实现*/
    @RequestMapping("keyword/list")
    @ResponseBody
    public ResponseVo<Page<Keyword>> keywordList(int page, int limit, String keyword, String url, String sort, String order){
        Page<Keyword> keywordList = keywordService.queryKeywordList(page, limit, keyword, url, sort, order);
        ResponseVo<Page<Keyword>> responseVo = new ResponseVo<>();
        if (keywordList != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(keywordList);
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }
    @RequestMapping("keyword/update")
    @ResponseBody
    public ResponseVo<Keyword> updateKeyword(@RequestBody Keyword keyword){
        ResponseVo<Keyword> responseVo = new ResponseVo<>();
        Keyword update = keywordService.updateKeyword(keyword);
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
    @RequestMapping("keyword/delete")
    @ResponseBody
    public ResponseVo<Keyword> deleteKeyword(@RequestBody Keyword keyword){
        ResponseVo<Keyword> responseVo = new ResponseVo<>();
        int delete = keywordService.deleteKeyword(keyword);
        if ( delete != 0){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(500);
        }
        return responseVo;
    }
    @RequestMapping("keyword/create")
    @ResponseBody
    public ResponseVo<Keyword> createKeyword(@RequestBody Keyword keyword){
        ResponseVo<Keyword> responseVo = new ResponseVo<>();
        Keyword create = keywordService.createKeyword(keyword);
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


    /*品牌制造商，4个方法实现*/
    @RequestMapping("brand/list")
    @ResponseBody
    public ResponseVo<Page<Brand>> brandList(int page, int limit, Integer id, String name, String sort, String order){
        Page<Brand> brandList = brandService.queryBrandList(page, limit, id, name, sort, order);
        ResponseVo<Page<Brand>> responseVo = new ResponseVo<>();
        if (brandList != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(brandList);
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }
    @RequestMapping("brand/delete")
    @ResponseBody
    public ResponseVo<Brand> brandDelete(@RequestBody Brand brand){
        ResponseVo<Brand> responseVo = new ResponseVo<>();
        int delete = brandService.deleteBrand(brand);
        if ( delete != 0){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(500);
        }
        return responseVo;
    }
    @RequestMapping("brand/create")
    @ResponseBody
    public ResponseVo<Brand> createBrand(@RequestBody Brand brand){
        ResponseVo<Brand> responseVo = new ResponseVo<>();
        Brand create = brandService.createBrand(brand);
        responseVo.setData(create);
        if (create != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }

    @RequestMapping("brand/update")
    @ResponseBody
    public ResponseVo<Brand> updateBrand(@RequestBody Brand brand){
        ResponseVo<Brand> responseVo = new ResponseVo<>();
        Brand update = brandService.updateBrand(brand);
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


    /*订单管理,两个方法实现。商品显示有一项显示不出来，应该是前端代码的问题*/
    @RequestMapping("order/list")                                                                                   //这个函数中的形参orderStatusArray需要用到Short包装类，以及底层实现的参数也需要
    @ResponseBody
    public ResponseVo<Page<Order>> orderList(int page, int limit, Short orderStatusArray, String sort, String order, Integer userId, String orderSn){
        Page<Order> orderList = orderService.queryOrderList(page, limit, orderStatusArray, sort, order, userId, orderSn);
        ResponseVo<Page<Order>> responseVo = new ResponseVo<>();
        if (orderList != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
            responseVo.setData(orderList);
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }
    @RequestMapping("order/detail")
    @ResponseBody
    public ResponseVo<OrderDetail> orderDetail(int id){
        ResponseVo<OrderDetail> responseVo = new ResponseVo<>();
        OrderDetail orderDetail = orderService.showOrderDetail(id);
        responseVo.setData(orderDetail);
        if (orderDetail != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }
    /*商品类目*/
    @RequestMapping("category/list")
    @ResponseBody
    public ResponseVo<List<Category>> categoryList(){
        ResponseVo<List<Category>> responseVo = new ResponseVo<>();
        List<Category> category = categoryService.queryCategoryList();
        responseVo.setData(category);
        if (category != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }

    @RequestMapping("category/l1")
    @ResponseBody
    public ResponseVo<List<CategoryForGoods>> categoryL1(){
        ResponseVo<List<CategoryForGoods>> responseVo = new ResponseVo<>();
        List<CategoryForGoods> category = categoryService.queryCategoryL1();
        responseVo.setData(category);
        if (category != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }

    @RequestMapping("category/update")
    @ResponseBody
    public ResponseVo<Category> categoryList(@RequestBody Category category){
        ResponseVo<Category> responseVo = new ResponseVo<>();
        int update = categoryService.updateCategory(category);
        if (update != 0){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }

    @RequestMapping("category/create")
    @ResponseBody
    public ResponseVo<Category> createCategory(@RequestBody Category category){
        ResponseVo<Category> responseVo = new ResponseVo<>();
        Category create = categoryService.createCategory(category);
        if (create != null){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }

    @RequestMapping("category/delete")
    @ResponseBody
    public ResponseVo<Category> deleteCategory(@RequestBody Category category){
        ResponseVo<Category> responseVo = new ResponseVo<>();
        int delete = categoryService.deleteCategory(category);
        if (delete != 0){
            responseVo.setErrno(0);
            responseVo.setErrmsg("成功");
        }else {
            responseVo.setErrmsg("失败");
            responseVo.setErrno(404);
        }
        return responseVo;
    }
}




