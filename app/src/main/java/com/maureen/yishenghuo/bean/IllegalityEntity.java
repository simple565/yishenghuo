package com.maureen.yishenghuo.bean;

import java.util.List;

/**
 * @author Lian
 * @create 2018/4/23
 * @Describe 交通违章数据模型
 */
public class IllegalityEntity {

    /**
     * status : 0
     * msg :
     * result : {"lsprefix":"皖","lsnum":"B91801","carorg":"anhui","usercarid":"1483850","list":[{"time":"2015-06-23 18:24:00.0","address":"赵非公路鼓浪路北约20米","content":"违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的","legalnum":"","price":"0","id":"3500713","score":"0"},{"time":"2015-06-05 18:20:00.0","address":"新松江路近人民北路东侧路段","content":"违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的","legalnum":"","price":"0","id":"3500714","score":"0"},{"time":"2015-06-08 18:22:00.0","address":"鼓浪路近291弄路段","content":"违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的","legalnum":"","price":"0","id":"3500715","score":"0"}]}
     */

    private String status;
    private String msg;
    private ResultBean result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * lsprefix : 皖
         * lsnum : B91801
         * carorg : anhui
         * usercarid : 1483850
         * list : [{"time":"2015-06-23 18:24:00.0","address":"赵非公路鼓浪路北约20米","content":"违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的","legalnum":"","price":"0","id":"3500713","score":"0"},{"time":"2015-06-05 18:20:00.0","address":"新松江路近人民北路东侧路段","content":"违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的","legalnum":"","price":"0","id":"3500714","score":"0"},{"time":"2015-06-08 18:22:00.0","address":"鼓浪路近291弄路段","content":"违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的","legalnum":"","price":"0","id":"3500715","score":"0"}]
         */

        private String lsprefix;
        private String lsnum;
        private String carorg;
        private String usercarid;
        private List<ListBean> list;

        public String getLsprefix() {
            return lsprefix;
        }

        public void setLsprefix(String lsprefix) {
            this.lsprefix = lsprefix;
        }

        public String getLsnum() {
            return lsnum;
        }

        public void setLsnum(String lsnum) {
            this.lsnum = lsnum;
        }

        public String getCarorg() {
            return carorg;
        }

        public void setCarorg(String carorg) {
            this.carorg = carorg;
        }

        public String getUsercarid() {
            return usercarid;
        }

        public void setUsercarid(String usercarid) {
            this.usercarid = usercarid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * time : 2015-06-23 18:24:00.0
             * address : 赵非公路鼓浪路北约20米
             * content : 违反规定停放、临时停车且驾驶人不在现场或驾驶人虽在现场拒绝立即驶离，妨碍其他车辆、行人通行的
             * legalnum :
             * price : 0
             * id : 3500713
             * score : 0
             */

            private String time;
            private String address;
            private String content;
            private String legalnum;
            private String price;
            private String id;
            private String score;

            public String getTime() {
                return time;
            }

            public void setTime(String time) {
                this.time = time;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getLegalnum() {
                return legalnum;
            }

            public void setLegalnum(String legalnum) {
                this.legalnum = legalnum;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }
        }
    }
}
