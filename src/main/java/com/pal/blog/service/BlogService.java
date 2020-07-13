package com.pal.blog.service;

import com.pal.blog.entity.Blog;
import com.pal.blog.queryvo.BlogQuery;
import com.pal.blog.queryvo.SearchBlog;
import com.pal.blog.queryvo.ShowBlog;

import java.util.List;

public interface BlogService {
    //保存新增博客
    int saveBlog(Blog blog);

    //查询文章管理列表
    List<BlogQuery> getAllBlog();
    //删除博客
    void deleteBlog(Long id);

    //查询编辑修改的文章
    ShowBlog getBlogById(Long id);

    //编辑修改文章
    int updateBlog(ShowBlog showBlog);

    //搜索博客管理列表
    List<BlogQuery> getBlogBySearch(SearchBlog searchBlog);
}
