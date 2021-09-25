package com.example.wblog.utils;

import com.example.wblog.bean.User;
import org.springframework.security.core.context.SecurityContextHolder;


public class Util {
    public static User getCurrentUser() {
//      获取用户身份信息，在未认证的情况下获取到的是用户名
//      在已认证的情况下获取到的是 UserDetails(UserDetails也是一个接口，里面有getUsername，getPassword的方法)
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println("user="+user);
        return user;
    }
}
