package com.example.wblog.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * tags
 * @author 
 */
@Data
public class Tags implements Serializable {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname;
    }

    private Integer id;

    private String tagname;

    private static final long serialVersionUID = 1L;
}