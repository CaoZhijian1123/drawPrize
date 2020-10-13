package com.console.util;

import java.util.UUID;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/10 16:36
 */
public class UuidUtil {
    /**
     * 获取12位uuid
     *
     * @return
     */
    public static String getUuid12() {
        String s = UUID.randomUUID().toString();
        s = s.substring(s.lastIndexOf("-") + 1).toUpperCase();
        return s;
    }
}
