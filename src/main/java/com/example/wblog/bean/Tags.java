package com.example.wblog.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * tags
 * @author 
 */
public class Tags {
    private Long id;
    private String tagName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }


    private static final long serialVersionUID = 1L;
}