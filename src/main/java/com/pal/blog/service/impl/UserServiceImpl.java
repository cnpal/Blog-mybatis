package com.pal.blog.service.impl;

import com.pal.blog.dao.UserDao;
import com.pal.blog.entity.User;
import com.pal.blog.service.UserService;
import com.pal.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author pal
 * @Date Created in 2020/7/12 18:18
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
