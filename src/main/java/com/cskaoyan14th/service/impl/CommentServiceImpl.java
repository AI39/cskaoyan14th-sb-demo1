package com.cskaoyan14th.service.impl;

import com.cskaoyan14th.bean.Comment;
import com.cskaoyan14th.bean.CommentData;
import com.cskaoyan14th.bean.CommentExample;
import com.cskaoyan14th.bean.CommentList;
import com.cskaoyan14th.mapper.CommentMapper;
import com.cskaoyan14th.service.CommentService;
import com.cskaoyan14th.vo.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Page<Comment> getCommentPage(int page, int limit, Integer userId, Integer valueId, String sort, String order) {
        PageHelper.startPage(page, limit);

        CommentExample commentExample = new CommentExample();
        commentExample.setOrderByClause(sort + " " + order);
        CommentExample.Criteria criteria = commentExample.createCriteria();
        if(userId == null && valueId == null) {
            criteria.andIdIsNotNull();
        } else if(userId != null && valueId == null) {
            criteria.andUserIdEqualTo(userId);
        } else if(userId == null && valueId != null) {
            criteria.andValueIdEqualTo(valueId);
        } else {
            criteria.andUserIdEqualTo(userId).andValueIdEqualTo(valueId);
        }

        List<Comment> commentList = commentMapper.selectByExample(commentExample);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        Page<Comment> commentPage = new Page<>(pageInfo.getList(), pageInfo.getTotal());
        return commentPage;
    }

    @Override
    public int deleteCommentById(Integer id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int getPicCount(int valueId, int type) {
        int picCount = commentMapper.getPicCount(valueId, type);
        return picCount;
    }

    @Override
    public int getAllCount(int valueId, int type) {
        int allCount = commentMapper.getAllCount(valueId, type);
        return allCount;
    }

    @Override
    public CommentList getWxCommentList(int valueId, int type, int page, int size, int showType) {  //showType为1只展示图片
        PageHelper.startPage(page, size);

        List<CommentData> commentDataList = commentMapper.getCommentData(valueId, type, showType);

        CommentList commentList = new CommentList();
        if(showType == 0) {
            commentList.setCount(commentMapper.getAllCount(valueId, type));
        } else if(showType == 1) {
            commentList.setCount(commentMapper.getPicCount(valueId, type));
        }

        commentList.setCurrentPage(page);


        PageInfo<CommentData> pageInfo = new PageInfo<>(commentDataList);
        List<CommentData> data = pageInfo.getList();
        commentList.setData(data);

        return commentList;
    }
}
