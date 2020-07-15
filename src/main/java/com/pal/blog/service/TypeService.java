package com.pal.blog.service;

import com.pal.blog.entity.Type;

import java.util.List;

public interface TypeService {
    //新增保存分类
    int saveType(Type type);

    //根据id查询分类
    Type getType(Long id);

    //查询所有分类
    List<Type> getAllType();

    //根据分类名称查询分类
    Type getTypeByName(String name);

    //编辑修改分类
    int updateType(Type type);

    //删除分类
    void deleteType(Long id);
    //查询所有分类
    List<Type>getAllTypeAndBlog();
}
