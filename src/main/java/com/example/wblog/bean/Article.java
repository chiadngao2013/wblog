package com.example.wblog.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * article
 * @author 
 */
public class Article implements Serializable {
    private Integer id;

    private String title;

    /**
     * md文件源码
     */
    private String mdcontent;

    /**
     * html源码
     */
    private String htmlcontent;

    private String summary;

    private Integer cid;

    private Integer uid;

    private Timestamp publishdate;

    private Timestamp edittime;

    /**
     * 0表示草稿箱，1表示已发表，2表示已删除
     */
    private Integer state;

    private Integer pageview;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMdcontent() {
        return mdcontent;
    }

    public void setMdcontent(String mdcontent) {
        this.mdcontent = mdcontent;
    }

    public String getHtmlcontent() {
        return htmlcontent;
    }

    public void setHtmlcontent(String htmlcontent) {
        this.htmlcontent = htmlcontent;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(Timestamp publishdate) {
        this.publishdate = publishdate;
    }

    public Date getEdittime() {
        return edittime;
    }

    public void setEdittime(Timestamp edittime) {
        this.edittime = edittime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }
}