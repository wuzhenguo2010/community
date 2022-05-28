package com.njupt.community.dao;

import com.njupt.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    //offset每页起始行行号
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit, int orderMode);

    //@Param注解用于给参数取别名
    // 如果只有一个参数，并且在<if>里使用，必须加别名.
    int selectDiscussPostRows(@Param("userId") int userId);

    //增加帖子
    int insertDiscussPost(DiscussPost discussPost);

    //查询帖子详情
    DiscussPost selectDiscussPostById(int id);

    //更新评论数量
    int updateCommentCount(int id, int commentCount);

    // 更新帖子状态
    int updateType(int id, int type);

    int updateStatus(int id, int status);

    int updateScore(int id, double score);

}
