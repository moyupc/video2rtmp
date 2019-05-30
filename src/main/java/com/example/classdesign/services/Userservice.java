package com.example.classdesign.services;

import com.example.classdesign.utils.MD5;
import com.example.classdesign.models.UserInfo;
import com.example.classdesign.repository.UserRepository;
import com.example.classdesign.results.Result;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice {

    @Autowired
    UserRepository userRepository;
    public Result createUser(String username, String userpsw){
        try {
            if (userRepository.findByUsername(username) == null) {
                String salt= RandomStringUtils.randomAlphanumeric(5);
                UserInfo user=new UserInfo(username,salt,MD5.string(userpsw+salt));
                userRepository.save(user);
                return Result.success("测试创建User");
            } else{
                return Result.error("username有了");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return Result.error("有毒 滚去debug");
        }
    }
    public Result findUserR(String username,String passwd) {
        try {
            System.out.println(username + "end");
            UserInfo user = userRepository.findByUsername(username);
            if (user != null) {
                String password = MD5.string(passwd + user.getSalt());
                System.out.println(password + "=" + user.getUserpsw());
                if (password.equals(user.getUserpsw())) {
                    return Result.success(user);
                } else {
                    return Result.error("wrong password");
                }
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
