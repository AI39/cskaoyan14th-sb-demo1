package com.cskaoyan14th.controller.wx;

import com.cskaoyan14th.bean.Comment;
import com.cskaoyan14th.bean.CommentList;
import com.cskaoyan14th.service.CommentService;
import com.cskaoyan14th.service.TopicService;
import com.cskaoyan14th.util.UserTokenManager;
import com.cskaoyan14th.vo.ResponseMapVo;
import com.cskaoyan14th.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
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
    public ResponseVo<CommentList> getCommentList(int valueId, int type, int showType, int page, int size){

        ResponseVo<CommentList> responseVo = new ResponseVo<>();
        CommentList data = commentService.getWxCommentList(valueId, type, page, size, showType);
        responseVo.setData(data);
        responseVo.setErrmsg("成功");
        responseVo.setErrno(0);
        return responseVo;
    }

/*    @RequestMapping("comment/list")
    @ResponseBody
    public ResponseVo<CommentList> getCommentList(int valueId, int type, int showType, int page, int size){
        ResponseVo<CommentList> responseVo=topicService.getCommentList(valueId,type,showType,page,size);
        return responseVo;
    }*/

    @RequestMapping("post")
    public ResponseVo<Comment> post(HttpServletRequest request, @RequestBody Comment comment) {
        ResponseVo<Comment> responseVo = new ResponseVo<>();

        //获取userId
        String token = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(token);
        if(userId == null || userId == 0) {
            responseVo.setErrmsg("请重新登陆");
            responseVo.setErrno(502);
            return responseVo;
        }
        Date date = new Date();
        comment.setUserId(userId);
        comment.setAddTime(date);
        comment.setUpdateTime(date);

        Integer id = commentService.insertComment(comment);
        if(id != null) {
            comment.setId(id);
            responseVo.setData(comment);
            responseVo.setErrmsg("成功");
            responseVo.setErrno(0);
            return responseVo;
        }
        responseVo.setErrmsg("服务器内部错误");
        responseVo.setErrno(502);
        return responseVo;
    }


}
