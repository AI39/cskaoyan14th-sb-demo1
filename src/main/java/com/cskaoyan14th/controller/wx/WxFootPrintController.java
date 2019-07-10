package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Footprint;
import com.cskaoyan14th.service.FootprintService;
import com.cskaoyan14th.util.UserTokenManager;
import com.cskaoyan14th.vo.ResponseMapVo;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yuechao Yang
 * @version 2019-07-10-11:18
 */
@RestController
@RequestMapping("/wx/footprint")
public class WxFootPrintController {
    @Autowired
    FootprintService footprintService;
    @RequestMapping("list")
    @ResponseBody
    public ResponseMapVo footPrintList(Integer page, Integer size, HttpServletRequest request){
        String tokenKey = request.getHeader("X-Litemall-Token");                                                //必须通过请求头来确定userId
        Integer userId = UserTokenManager.getUserId(tokenKey);
        //通过请求头获得userId，进而可以获得一切关于user的信息
        //**************************
        if (userId == null) {
            return new ResponseMapVo(404,null, "错误");
        }
        ResponseMapVo responseMapVo = new ResponseMapVo();
        Map<String, Object> data = new HashMap<>();
        List<Footprint> footprintList = footprintService.queryFootprintList(page, size);
        data.put("footprintList", footprintList);
        int totalPages = footprintService.queryFootprintTotalPages(page, size);
        data.put("totalPages", totalPages);
        if (data != null){
            responseMapVo.setData(data);
            responseMapVo.setErrmsg("成功");
            responseMapVo.setErrno(0);
        }else {
            responseMapVo.setErrno(404);
            responseMapVo.setErrmsg("失败");
        }
        return responseMapVo;
    }
    //删除足迹由于前端没有这个按钮，所以没法删除
}
