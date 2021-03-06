package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Keyword;
import com.cskaoyan14th.service.SearchService;
import com.cskaoyan14th.util.UserTokenManager;
import com.cskaoyan14th.vo.ResponseMapVo;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("wx/search")
public class WxSearchController {

    @Autowired
    SearchService searchService;

    @RequestMapping("helper")
    public ResponseVo<Object> helper(String keyword) {

        ResponseVo<Object> response = new ResponseVo<>();

        List<String> fussyKeyword = searchService.getFussyKeyword(keyword);

        response.setErrmsg("成功");
        response.setErrno(0);

        response.setData(fussyKeyword);

        return response;
    }

    @RequestMapping("index")
    public ResponseMapVo index(HttpServletRequest request) {
        //获取userid
        String token = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(token);

        ResponseMapVo responseMapVo = new ResponseMapVo();
        Keyword defaultKeyword = searchService.getDefaultKeyWord();

        List<Keyword> hotKeywordList = searchService.getHotKeywordList();
        List<Map<String, String>> historyKeywordList = new ArrayList<>();

        if(userId != null) {
            historyKeywordList = searchService.getHistoryKeywordList(userId);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("defaultKeyword", defaultKeyword);
        data.put("hotKeywordList", hotKeywordList);
        data.put("historyKeywordList", historyKeywordList);

        responseMapVo.setErrmsg("成功");
        responseMapVo.setErrno(0);
        responseMapVo.setData(data);

        return responseMapVo;
    }

    @RequestMapping("clearhistory")
    public ResponseVo<Object> clearHistory(HttpServletRequest request) {

        ResponseVo<Object> responseVo = new ResponseVo<>();
        //获取userid
        String token = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(token);

        if(userId == null) {
            responseVo.setErrno(502);
            responseVo.setErrmsg("请登录");
        }


        searchService.clearHistoryByUserId(userId);

        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");

        return responseVo;
    }
}
