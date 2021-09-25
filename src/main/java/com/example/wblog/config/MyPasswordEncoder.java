package com.example.wblog.config;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

//用于登录时的密码校验，和注册时生成密码
@Component
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
//    此方法将前端传递过来的明文密码，通过MD5编译成密文
    public String encode(CharSequence rawPassword) {
        System.out.println(rawPassword);
        return DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes());
    }
    /**
     *  charSequence 明文
     *  encodedPassword密文
     */

    @Override
//    用来对比数据库存储的密文和生成的密文是否一样
    public boolean matches(CharSequence rawPassword, String encodedPassword) {

        return encodedPassword.equals(DigestUtils.md5DigestAsHex(rawPassword.toString().getBytes()));

    }
}
