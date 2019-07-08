package com.cskaoyan14th.service;

import com.cskaoyan14th.bean.Comment;
import com.cskaoyan14th.vo.Page;

public interface CommentService {
    Page<Comment> getCommentPage(int page, int limit, Integer userId, Integer valueId, String sort, String order);

    int deleteCommentById(Integer id);
}
