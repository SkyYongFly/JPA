package com.example.jpa.controller;

import com.example.jpa.daomain.User;
import com.example.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关请求处理控制器
 *
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/10/9 14:51
 */
@RestController("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id")Long id){
        return this.userRepository.findOne(id);
    }
}
