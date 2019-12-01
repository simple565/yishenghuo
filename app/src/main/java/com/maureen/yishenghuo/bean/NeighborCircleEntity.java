package com.maureen.yishenghuo.bean;

import java.util.List;

/**
 * @author Lian
 * @create 2018/4/24
 * @Describe
 */
public class NeighborCircleEntity {

    /**
     * code : 0
     * data : [{"content":{"content_id":13,"user_id":8,"nickname":"cfc","content":"开始忙碌","release_time":"2018-03-20-00"},"comment":[{"comment_id":5,"comment_content":"你说得对","user_id":8,"pcomment_id":0,"nickname":"cfc"}]}]
     * msg :
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * content : {"content_id":13,"user_id":8,"nickname":"cfc","content":"开始忙碌","release_time":"2018-03-20-00"}
         * comment : [{"comment_id":5,"comment_content":"你说得对","user_id":8,"pcomment_id":0,"nickname":"cfc"}]
         */

        private ContentBean content;
        private List<CommentBean> comment;

        public ContentBean getContent() {
            return content;
        }

        public void setContent(ContentBean content) {
            this.content = content;
        }

        public List<CommentBean> getComment() {
            return comment;
        }

        public void setComment(List<CommentBean> comment) {
            this.comment = comment;
        }

        public static class ContentBean {
            /**
             * content_id : 13
             * user_id : 8
             * nickname : cfc
             * content : 开始忙碌
             * release_time : 2018-03-20-00
             */

            private int content_id;
            private int user_id;
            private String nickname;
            private String content;
            private String release_time;

            public int getContent_id() {
                return content_id;
            }

            public void setContent_id(int content_id) {
                this.content_id = content_id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getRelease_time() {
                return release_time;
            }

            public void setRelease_time(String release_time) {
                this.release_time = release_time;
            }
        }

        public static class CommentBean {
            /**
             * comment_id : 5
             * comment_content : 你说得对
             * user_id : 8
             * pcomment_id : 0
             * nickname : cfc
             */

            private int comment_id;
            private String comment_content;
            private int user_id;
            private int pcomment_id;
            private String nickname;

            public int getComment_id() {
                return comment_id;
            }

            public void setComment_id(int comment_id) {
                this.comment_id = comment_id;
            }

            public String getComment_content() {
                return comment_content;
            }

            public void setComment_content(String comment_content) {
                this.comment_content = comment_content;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public int getPcomment_id() {
                return pcomment_id;
            }

            public void setPcomment_id(int pcomment_id) {
                this.pcomment_id = pcomment_id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }
        }
    }
}
