package com.example.wblog.controller;


import com.example.wblog.bean.Article;
import com.example.wblog.mapper.ArticleMapper;
import com.example.wblog.service.ArticleService;
import com.example.wblog.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")

public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public Map<String, Object> getArticleByState(@RequestParam(value = "state", defaultValue = "-1") Integer state , @RequestParam (value = "page",defaultValue = "1") Integer page, @RequestParam(value = "count" ,defaultValue = "6") Integer count,String keywords){
        int totalCount = articleService.getArticleCountByState(state, Util.getCurrentUser().getId(),keywords);
        List<Article> articles =articleService.getArticleByState(state,page,count,keywords);
        Map<String,Object > map =new HashMap<>();
        map.put("totalCount",totalCount);
        map.put("articles",articles);
        return map;
    }
}
