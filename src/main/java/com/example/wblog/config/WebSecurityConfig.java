package com.example.wblog.config;

import com.example.wblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/category/all").authenticated()
//                .antMatchers("/admin/**","/reg").hasRole("超级管理员")///admin/**的URL都需要有超级管理员角色，如果使用.hasAuthority()方法来配置，需要在参数中加上ROLE_,如下.hasAuthority("ROLE_超级管理员")
                .antMatchers("/admin/**").hasRole("超级管理员")
                .anyRequest().authenticated()//其他的路径都是登录后即可访问
                .and().formLogin().loginPage("/index.html").successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write("{\"status\":\"success\",\"msg\":\"登录成功\"}");
                out.flush();
                out.close();
            }
        })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                        httpServletResponse.setContentType("application/json;charset=utf-8");
                        PrintWriter out = httpServletResponse.getWriter();
                        out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                        out.flush();
                        out.close();
                    }
                }).loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .and().logout().logoutSuccessUrl("/index.html").permitAll()
                .and().csrf().disable().exceptionHandling().accessDeniedHandler(getAccessDeniedHandler());
    }

    @Override
//    过滤器忽略以下路径的请求，意思就是即使没有认证，游客也可以访问的资源。
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/blogimg/**","/index.html","/static/**","/reg");
    }

    @Bean
//    获取访问被拒绝的处理程序，就是用户权限不足时的处理
    AccessDeniedHandler getAccessDeniedHandler() {
        return new com.example.wblog.config.AuthenticationAccessDeniedHandler();
    }
}