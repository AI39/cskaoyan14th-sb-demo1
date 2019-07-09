package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("wx/search")
public class WxSearchController {
    @RequestMapping("helper")
    public ResponseVo<Object> helper(String keyword) {
        ResponseVo<Object> response = new ResponseVo<>();
        response.setErrmsg("成功");
        response.setErrno(0);
        return response;
    }
}
