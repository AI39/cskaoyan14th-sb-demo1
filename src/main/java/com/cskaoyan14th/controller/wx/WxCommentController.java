package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.CommentList;
import com.cskaoyan14th.service.CommentService;
import com.cskaoyan14th.service.TopicService;
import com.cskaoyan14th.vo.ResponseMapVo;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("wx/comment")
public class WxCommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    TopicService topicService;

    @RequestMapping("count")
    public ResponseMapVo count(int valueId, int type) {
        ResponseMapVo responseMapVo = new ResponseMapVo();
        Map<String, Object> map = new HashMap<>();

        int hasPicCount = commentService.getPicCount(valueId, type);
        int allCount = commentService.getAllCount(valueId, type);

        map.put("hasPicCount", hasPicCount);
        map.put("allCount", allCount);

        responseMapVo.setErrno(0);
        responseMapVo.setErrmsg("成功");
        responseMapVo.setData(map);
        return responseMapVo;
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVo<CommentList> getCommentList(int valueId, int type, int showType, int page, int size){

        ResponseVo<CommentList> responseVo = new ResponseVo<>();
        //topic
        if(type == 1) {
            responseVo = topicService.getCommentList(valueId, type, showType, page, size);
        }

        //goods
        if(type == 0) {
            CommentList data = commentService.getWxCommentList(valueId, type, page, size, showType);
            responseVo.setData(data);
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
        }
        return responseVo;
    }
}
