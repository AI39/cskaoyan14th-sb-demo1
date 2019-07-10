package com.cskaoyan14th.controller;

import com.cskaoyan14th.bean.Comment;
import com.cskaoyan14th.service.CommentService;
import com.cskaoyan14th.vo.Page;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("admin")
public class CommentController {

    @Autowired
    CommentService commentService;

    //一、商品评论展示和查询
    @RequestMapping("comment/list")
    public ResponseVo<Page<Comment>> list(int page, int limit, Integer userId, Integer valueId, String sort, String order) {

        Page<Comment> commentPage = commentService.getCommentPage(page, limit, userId, valueId, sort, order);
        ResponseVo<Page<Comment>> responseVo = new ResponseVo<>(0, commentPage, "成功");
        return responseVo;
    }

    //二、删除
    @RequestMapping("comment/delete")
    public ResponseVo<Object> delete(@RequestBody Comment comment) {

        ResponseVo<Object> responseVo = new ResponseVo<>();
        commentService.deleteCommentById(comment.getId());

        responseVo.setErrno(0);
        responseVo.setErrmsg("成功");

        return responseVo;
    }

    //三、回复
    @RequestMapping("order/reply")
    public ResponseVo<Object> reply(@RequestBody Map<String, Integer> param) {

        ResponseVo<Object> responseVo = new ResponseVo<>();

        Integer commentId = param.get("commentId");
        responseVo.setErrmsg("订单商品已回复");
        responseVo.setErrno(622);

        return responseVo;
    }

}
