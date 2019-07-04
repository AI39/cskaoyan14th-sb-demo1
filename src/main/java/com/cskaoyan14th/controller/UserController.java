package com.cskaoyan14th.controller;


import com.cskaoyan14th.bean.*;
import com.cskaoyan14th.service.*;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;

    @RequestMapping("user/list")
    @ResponseBody
    public ResponseVo<Page<User>> UserList(int page,int limit,String sort,String order){
        ResponseVo<Page<User>> responseVo = new ResponseVo<>();
        Page<User> pageList = userService.getPageList(page, limit, sort, order);
        //Page<User> pageList = userService.getPageList(page, limit);
        if (pageList.getTotal() < 0){
            responseVo.setErrno(-1);
            responseVo.setErrmsg("系统出错，请联系管理员");
        }else {
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
            responseVo.setData(pageList);
        }
        return responseVo;
    }

    @RequestMapping("address/list")
    @ResponseBody
    public ResponseVo<Page<Address>> addressList(int page, int limit, String sort, String order){
        ResponseVo<Page<Address>> responseVo = new ResponseVo<>();
        Page<Address> pageList = addressService.getPageList(page, limit, sort, order);
        if (pageList.getTotal() < 0){
            responseVo.setErrno(-1);
            responseVo.setErrmsg("系统出错，请联系管理员");
        }else {
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
            responseVo.setData(pageList);
        }
        return responseVo;
    }

    @Autowired
    CollectService collectService;
    @RequestMapping("collect/list")
    @ResponseBody
    public ResponseVo<Page<Collect>> collectList(int page, int limit, String sort, String order){
        ResponseVo<Page<Collect>> responseVo = new ResponseVo<>();
        Page<Collect> pageList = collectService.getPageList(page, limit, sort, order);
        if (pageList.getTotal() < 0){
            responseVo.setErrno(-1);
            responseVo.setErrmsg("系统出错，请联系管理员");
        }else {
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
            responseVo.setData(pageList);
        }
        return responseVo;
    }
    @Autowired
    FootprintService footprintService;
    @RequestMapping("footprint/list")
    @ResponseBody
    public ResponseVo<Page<Footprint>> footprintList(int page, int limit, String sort, String order){
        ResponseVo<Page<Footprint>> responseVo = new ResponseVo<>();
        Page<Footprint> pageList = footprintService.getPageList(page, limit, sort, order);
        if (pageList.getTotal() < 0){
            responseVo.setErrno(-1);
            responseVo.setErrmsg("系统出错，请联系管理员");
        }else {
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
            responseVo.setData(pageList);
        }
        return responseVo;
    }
    @Autowired
    SearchHistoryService historyService;
    @RequestMapping("history/list")
    @ResponseBody
    public ResponseVo<Page<SearchHistory>> historyList(int page, int limit, String sort, String order){
        ResponseVo<Page<SearchHistory>> responseVo = new ResponseVo<>();
        Page<SearchHistory> pageList = historyService.getPageList(page, limit, sort, order);
        if (pageList.getTotal() < 0){
            responseVo.setErrno(-1);
            responseVo.setErrmsg("系统出错，请联系管理员");
        }else {
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
            responseVo.setData(pageList);
        }
        return responseVo;
    }
    @Autowired
    FeedbackService feedbackService;
    @RequestMapping("feedback/list")
    @ResponseBody
    public ResponseVo<Page<Feedback>> feedbackList(int page, int limit, String sort, String order){
        ResponseVo<Page<Feedback>> responseVo = new ResponseVo<>();
        Page<Feedback> pageList = feedbackService.getPageList(page, limit, sort, order);
        if (pageList.getTotal() < 0){
            responseVo.setErrno(-1);
            responseVo.setErrmsg("系统出错，请联系管理员");
        }else {
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
            responseVo.setData(pageList);
        }
        return responseVo;
    }

}
