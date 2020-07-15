package com.pal.blog.service.impl;

import com.pal.blog.dao.BlogDao;
import com.pal.blog.dao.CommentDao;
import com.pal.blog.entity.Comment;
import com.pal.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author pal
 * @Date Created in 2020/7/14 10:57
 * @Version: 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BlogDao blogDao;

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();

    /**
     * @Description: 查询评论
     * @Param: blogId：博客id
     * @Return: 评论消息
     */
    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {

        List<Comment> comments = commentDao.findByBlogIdParentIdNull(blogId, -1l);
        for (Comment comment : comments) {
            Long id = comment.getId();
            String parentNickname = comment.getNickname();
            List<Comment> childComments = commentDao.findByBlogIdParentIdNotNull(blogId, id);
            combineChildren(blogId,childComments,parentNickname);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }
    /**
     * @Description: 查询出子评论
     * @Param: childComments：所有子评论
     * @Param: parentNickname1：父评论姓名
     * @Return:
     */
    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname) {
        //判断是否有一级子评论
        if(childComments.size() > 0){
            //循环找出子评论的id
            for(Comment childComment : childComments){
                String parentNickname1 = childComment.getNickname();
                childComment.setParentNickname(parentNickname);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
                //查询出子二级评论
                recursively(blogId, childId, parentNickname1);
            }
        }
    }
    /**
     * @Description: 循环迭代找出子集回复
     * @Param: chileId:子评论id
     * @Param: parentNickname1:子评论姓名
     * @Return:
     */
    private void recursively(Long blogId, Long childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentDao.findByBlogIdAndReplayId(blogId,childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId,replayId,parentNickname);
            }
        }
    }

    //新增评论
    @Override
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        int comments = commentDao.saveComment(comment);
        //文章评论计数
        blogDao.getCommentCountById(comment.getBlogId());
        return comments;
    }

    //删除评论
    @Override
    public void deleteComment(Comment comment,Long id) {
        commentDao.deleteComment(id);
        blogDao.getCommentCountById(comment.getBlogId());
    }
}
