package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.SystemKeyValue;
import com.cskaoyan14th.vo.ResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

public interface SystemService {
    String querySystemByKeyValue(String keyName);
    int updateSystemKeyValue( String keyValue, String keyName);

    String querySystemByFrightMin( String keyName);

    int updateSystemByFrightMin( String keyValue, String keyName);

    String querySystemByOrder(String keyName);

    int updateSystemByOrder( String keyValue, String keyName);



}
