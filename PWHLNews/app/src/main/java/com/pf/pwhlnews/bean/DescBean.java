package com.pf.pwhlnews.bean;


/**
 * Created by cuitpf on 2017/6/7.
 */

public class DescBean extends BaseModle {

    private static final long serialVersionUID = 1L;

    private int id;
    private String ctime;
    private String description;
    private String eassay;
    private int picUrl;
    private String title;

    public int getId() {
        return id;
    }

    public void set_Id(int _id) {
        this.id = _id;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(int picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEassay() {
        return eassay;
    }

    public void setEassay(String eassay) {
        this.eassay = eassay;
    }


}
