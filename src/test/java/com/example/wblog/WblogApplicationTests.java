package com.example.wblog;

import com.example.wblog.bean.Role;
import com.example.wblog.bean.User;
import com.example.wblog.mapper.RolesMapper;
import com.example.wblog.mapper.UserMapper;
import com.example.wblog.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class WblogApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RolesMapper rolesMapper;

    @Test
    public void test() {
        User user = userMapper.loadUserByUsername("chidangao2013");
        List<Role> roles = rolesMapper.getRolesByUid(user.getId());
        System.out.println(user.getId());

    }
}
