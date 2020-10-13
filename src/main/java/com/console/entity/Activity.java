package com.console.entity;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/10 17:08
 */
public class Activity {

    private Integer id;

    private String name;

    private String note;

    private String createDate;

    private String codeLink;


    /**
     * 0不开放，其他开放
     */
    private Short open;


    public String getCodeLink() {
        return codeLink;
    }

    public void setCodeLink(String codeLink) {
        this.codeLink = codeLink;
    }


    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", createDate='" + createDate + '\'' +
                ", codeLink='" + codeLink + '\'' +
                ", open=" + open +
                '}';
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Short getOpen() {
        return open;
    }

    public void setOpen(Short open) {
        this.open = open;
    }
}
