package com.console.entity;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/10 17:08
 */
public class Prize {

    /**
     * id
     */
    private Integer id;
    /**
     * 一等奖，二等奖···
     */
    private String title;

    /**
     * 奖品数量
     */
    private String num;

    /**
     * 奖品名称，实物名
     */
    private String prizeName;

    /**
     * 附加说明信息
     */
    private String note;


    @Override
    public String toString() {
        return "Prize{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num='" + num + '\'' +
                ", prizeName='" + prizeName + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
