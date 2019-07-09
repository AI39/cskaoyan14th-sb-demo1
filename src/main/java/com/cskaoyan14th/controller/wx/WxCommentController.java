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

@RestController
@RequestMapping("wx/comment")
public class WxCommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    TopicService topicService;

    @RequestMapping("count")
    public ResponseMapVo count() {
        ResponseMapVo responseMapVo = new ResponseMapVo();
        return null;
    }

/*    @RequestMapping("comment/list")
    @ResponseBody
    public ResponseVo<CommentList> getCommentList(int valueId, int type, int showType, int page, int size){
        ResponseVo<CommentList> responseVo=topicService.getCommentList(valueId,type,showType,page,size);
        return responseVo;
    }*/
}
