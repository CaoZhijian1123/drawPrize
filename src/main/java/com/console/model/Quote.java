package com.console.model;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/11 22:00
 */
public class Quote {

    private String code;
    private String msg;
    private Data data;
    private Author author;

    @Override
    public String toString() {
        return "Quote{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", author=" + author +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public class Data {
        private String content;
        private String author;
        private Integer typeid;

        @Override
        public String toString() {
            return "Data{" +
                    "content='" + content + '\'' +
                    ", author='" + author + '\'' +
                    ", typeid=" + typeid +
                    '}';
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public Integer getTypeid() {
            return typeid;
        }

        public void setTypeid(Integer typeid) {
            this.typeid = typeid;
        }
    }

    public class Author {
        private String name;
        private String desc;

        @Override
        public String toString() {
            return "Author{" +
                    "name='" + name + '\'' +
                    ", desc='" + desc + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
