package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Log;
import com.cskaoyan14th.service.LogService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin/log")
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Page<Log>> list(int page , int limit , String name){

        ResponseVo<Page<Log>> logResponseVo = logService.queryLogAll(page,limit,name);
        return logResponseVo;
    }
}
