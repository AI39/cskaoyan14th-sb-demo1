package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Log;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.stereotype.Service;


public interface LogService {

    ResponseVo<Page<Log>> queryLogAll(int page, int limit, String name);
}
