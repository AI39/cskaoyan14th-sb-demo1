package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Keyword;
import com.cskaoyan14th.service.SearchHistoryService;
import com.cskaoyan14th.service.SearchService;
import com.cskaoyan14th.vo.ResponseMapVo;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        response.setErrmsg("成功");
        response.setErrno(0);
        return response;
    }

    @RequestMapping("index")
    public ResponseMapVo index(HttpServletRequest request) {

        ResponseMapVo responseMapVo = new ResponseMapVo();
        Keyword defaultKeyword = searchService.getDefaultKeyWord();
        List<Keyword> hotKeywordList = searchService.getHotKeywordList();
        List<Map<String, String>> historyKeywordList = null;

        Map<String, Object> data = new HashMap<>();
        data.put("defaultKeyword", defaultKeyword);
        data.put("hotKeywordList", hotKeywordList);
        data.put("historyKeywordList", historyKeywordList);

        responseMapVo.setErrmsg("成功");
        responseMapVo.setErrno(0);
        responseMapVo.setData(data);
        return responseMapVo;
    }
}
