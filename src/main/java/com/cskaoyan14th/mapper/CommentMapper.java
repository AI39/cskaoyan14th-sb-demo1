package com.cskaoyan14th.mapper;

import com.cskaoyan14th.bean.Comment;
import com.cskaoyan14th.bean.CommentData;
import com.cskaoyan14th.bean.CommentExample;
import java.util.List;

import com.cskaoyan14th.bean.CommentForGoodsDetail;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {

    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<CommentForGoodsDetail> selectLimitCommentForGoodsDetailByGoodId(@Param("id") int id, @Param("limit") int limit);

    int selectCountByGoodsId(@Param("id") int id);

    int getPicCount(@Param("valueId") int valueId, @Param("type") int type);

    int getAllCount(@Param("valueId")int valueId, @Param("type") int type);

    List<CommentData> getCommentData(@Param("valueId") int valueId, @Param("type") int type, @Param("showType") int showType);
}