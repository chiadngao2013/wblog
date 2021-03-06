package com.example.wblog.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * tags
 * @author
 */

@Data
public class User implements UserDetails {


    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
//    账户是否过期
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
//    账户是否被锁定
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
//    账户密码是否过期
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
//    表示该账户是否启用，默认为1(启用)，0
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    @JsonIgnore
//  获取用户权限，其实就是将用户的数据从roles表转换成list返回
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private Long id;

    private String username;

    private String password;

    private String nickname;

    private boolean enabled;

    private List<Role> roles;

    private String email;

    private String userface;

    private Timestamp regTime;
}
