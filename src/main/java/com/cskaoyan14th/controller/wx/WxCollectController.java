package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.service.CollectService;
import com.cskaoyan14th.util.UserTokenManager;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("wx/collect")
public class WxCollectController {
    @Autowired
    CollectService collectService;

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<Map<String, Object>> list(Integer type, Integer page, Integer size, HttpServletRequest request) {
        //前端写了一个token放在请求头中
        //*************************
        //获得请求头
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseVo(-1, null, "错误");
        }

        Map<String, Object> map = collectService.getCollectDataList(page, size, userId, type);

        return new ResponseVo<>(0, map, "成功");
    }

    @RequestMapping("addordelete")
    @ResponseBody
    public ResponseVo<Map<String, Object>> list(@RequestBody Map<String, Object> requestMap, HttpServletRequest request) {
        Integer type = (Integer)requestMap.get("type");
        Integer valueId = (Integer)requestMap.get("valueId");

        //前端写了一个token放在请求头中
        //*************************
        //获得请求头
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseVo(-1, null, "错误");
        }

        Map<String, Object> map = new HashMap<>();
        String typeStr = collectService.addordeleteCollect(userId, valueId);
        map.put("type", typeStr);

        return new ResponseVo<>(0, map, "成功");
    }
}
