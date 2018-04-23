package com.yishenghuo.yishenghuo.Model.bean;



import java.util.List;

/**
 * @author Lian
 * @create 2018/4/22
 * @Describe 邻居圈动态数据模型
 */
public class NeighborCircleEntity {
    private int code;
    private String msg;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }


    public static class DataBean {
        private int content_id;
        private Content content;
        private List<Comment> comments;

        public int getContent_id() {
            return content_id;
        }

        public void setContent_id(int content_id) {
            this.content_id = content_id;
        }

        public Content getContent() {
            return content;
        }

        public void setContent(Content content) {
            this.content = content;
        }

        public static class Content {
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

        public List <Comment> getComments() {
            return comments;
        }

        public void setComments(List <Comment> comments) {
            this.comments = comments;
        }

        public static class Comment{
            private int comment_id;
            private int user_id;
            private int pcomment_id;
            private String nickname;
            private String comment;

            public int getComment_id() {
                return comment_id;
            }

            public void setComment_id(int comment_id) {
                this.comment_id = comment_id;
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

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }
        }
    }

}
