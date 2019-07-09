package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Log;
import com.cskaoyan14th.mapper.LogMapper;
import com.cskaoyan14th.service.LogService;
import com.cskaoyan14th.vo.DateCurrentTime;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;
    @Override
    public ResponseVo<Page<Log>> queryLogAll(int page, int limit, String name) {
        ResponseVo<Page<Log>> adminResponseVo = new ResponseVo<>();

        PageHelper.startPage(page,limit);
        //查询
        List<Log> logList = logMapper.queryAdminAll(name);

        PageInfo pageInfo = new PageInfo(logList);

        Page<Log> adminPage = new Page<Log>(pageInfo.getList(), pageInfo.getTotal());
        //判断 是否为空
        if(logList != null){
            adminResponseVo.setErrno(0);
            adminResponseVo.setErrmsg("成功");
            adminResponseVo.setData(adminPage);
        }

        return adminResponseVo;
    }

    @Override
    public int insertLogin(String ipAddr, String username) {
        Log log = new Log();
        Date date = DateCurrentTime.dateCurrentTime();
        log.setAction("登录");
        log.setAddTime(date);
        log.setAdmin(username);
        log.setIp(ipAddr);
        log.setStatus(true);
        log.setUpdateTime(date);
        log.setDeleted(false);
        log.setType(1);
        int i = logMapper.insertLogin(log);
        return i;
    }

    @Override
    public int insertUpdate(String username, String ipAddr) {
        Log log = new Log();
        Date date = DateCurrentTime.dateCurrentTime();
        log.setAction("修改");
        log.setAddTime(date);
        log.setAdmin(username);
        log.setIp(ipAddr);
        log.setStatus(true);
        log.setUpdateTime(date);
        log.setDeleted(false);
        log.setType(1);
        int i = logMapper.insertLogin(log);
        return i;

    }
}
