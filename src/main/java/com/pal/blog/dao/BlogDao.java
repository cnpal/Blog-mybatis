package com.pal.blog.dao;

import com.pal.blog.entity.Blog;
import com.pal.blog.queryvo.BlogQuery;
import com.pal.blog.queryvo.SearchBlog;
import com.pal.blog.queryvo.ShowBlog;
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
}
