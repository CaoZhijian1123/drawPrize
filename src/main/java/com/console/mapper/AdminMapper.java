package com.console.mapper;

/**
 * @author caozj, (Zhijian Cao) <br/>
 * Beijing, China <br/>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/12 13:35
 */
public interface AdminMapper {

    /**
     * 查询用户密码
     *
     * @param name
     * @return
     */
    String getPwd(String name);

}
