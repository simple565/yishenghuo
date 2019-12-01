package com.maureen.yishenghuo.bean;

public class DynamicItemBean {
    private long time;
    private String title;
    private String description;
    private String imgURL;

    public DynamicItemBean(long time, String name, String description, String imgURL) {
        this.time = time;
        this.title = name;
        this.description = description;
        this.imgURL = imgURL;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDecribtion(String description) {
        this.description = description;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }
}
