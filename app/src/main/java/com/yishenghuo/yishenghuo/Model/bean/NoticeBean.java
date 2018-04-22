package com.yishenghuo.yishenghuo.Model.bean;

public class NoticeBean {

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataBean {
        private String notice_title;
        private String notice_time;
        private String notice_details;

        public void setNotice_title(String notice_title) {
            this.notice_title = notice_title;
        }

        public String getNotice_title() {
            return notice_title;
        }

        public void setNotice_time(String notice_time) {
            this.notice_time = notice_time;
        }

        public String getNotice_time() {
            return notice_time;
        }

        public void setNotice_details(String notice_details) {
            this.notice_details = notice_details;
        }

        public String getNotice_details() {
            return notice_details;
        }
    }
}
