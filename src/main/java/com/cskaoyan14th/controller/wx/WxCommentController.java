package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.service.CommentService;
import com.cskaoyan14th.vo.ResponseMapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wx/comment")
public class WxCommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("count")
    public ResponseMapVo count() {
        ResponseMapVo responseMapVo = new ResponseMapVo();
        return null;
    }
}
