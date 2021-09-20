package com.example.wblog.bean;

import java.io.Serializable;
import lombok.Data;

/**
 * roles
 * @author 
 */
@Data
public class Role implements Serializable {
    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Integer id;

    private String name;

    private static final long serialVersionUID = 1L;
}