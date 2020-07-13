package com.pal.blog.service.impl;

import com.pal.blog.dao.BlogDao;
import com.pal.blog.entity.Blog;
import com.pal.blog.queryvo.BlogQuery;
import com.pal.blog.queryvo.SearchBlog;
import com.pal.blog.queryvo.ShowBlog;
import com.pal.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author pal
 * @Date Created in 2020/7/13 11:12
 * @Version: 1.0
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogDao blogDao;


    //搜索博客管理列表
    @Override
    public List<BlogQuery> getBlogBySearch(SearchBlog searchBlog) {
        return blogDao.searchByTitleAndType(searchBlog);
    }
    //保存新增博客
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setViews(0);
        blog.setCommentCount(0);
        return blogDao.saveBlog(blog);
    }

    //查询文章管理列表
    @Override
    public List<BlogQuery> getAllBlog() {
        return blogDao.getAllBlogQuery();
    }

    //删除博客
    @Override
    public void deleteBlog(Long id) {
        blogDao.deleteBlog(id);
    }
    //查询编辑修改的文章
    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }

    //编辑修改文章
    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogDao.updateBlog(showBlog);
    }
}