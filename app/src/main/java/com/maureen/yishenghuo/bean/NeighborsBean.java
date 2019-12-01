package com.maureen.yishenghuo.bean;

/**
 * @author Lian
 * @create 2017/5/22
 * @Describe 邻居数据模型
 */
public class NeighborsBean {
    private String nickname;
    private String faviconURL;
    private String address;

    public NeighborsBean() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getFaviconURL() {
        return faviconURL;
    }

    public void setFaviconURL(String faviconURL) {
        this.faviconURL = faviconURL;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
