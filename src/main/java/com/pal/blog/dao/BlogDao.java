package com.pal.blog.dao;

import com.pal.blog.entity.Blog;
import com.pal.blog.queryvo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogDao {
    //保存新增博客
    int saveBlog(Blog blog);

    //查询文章管理列表
    List<BlogQuery> getAllBlogQuery();
    //删除博客
    void deleteBlog(Long id);
    //编辑博客
    int updateBlog(ShowBlog showBlog);

    //查询编辑修改的文章
    ShowBlog getBlogById(Long id);

    //搜索博客管理列表
    List<BlogQuery> searchByTitleAndType(SearchBlog searchBlog);

    //查询首页最新博客列表信息
    List<FirstPageBlog> getFirstPageBlog();

    //查询首页最新推荐信息
    List<RecommendBlog> getAllRecommendBlog();

    //搜索博客列表
    List<FirstPageBlog> getSearchBlog(String query);

    //统计博客总数
    Integer getBlogTotal();

    //统计访问总数
    Integer getBlogViewTotal();

    //统计评论总数
    Integer getBlogCommentTotal();

    //统计留言总数
    Integer getBlogMessageTotal();
}
