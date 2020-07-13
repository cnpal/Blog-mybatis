package com.pal.blog.service;

import com.pal.blog.entity.Picture;

import java.util.List;

/**
 * @Author pal
 * @Date Created in 2020/7/13 15:42
 * @Version: 1.0
 */
public interface PictureService {

    //查询照片
    List<Picture> listPicture();

    //添加图片
    int savePicture(Picture picture);

    //根据id查询照片
    Picture getPicture(Long id);

    //编辑修改相册
    int updatePicture(Picture picture);

    //删除照片
    void deletePicture(Long id);

}