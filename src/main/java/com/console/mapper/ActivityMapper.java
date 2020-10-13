package com.console.mapper;

import com.console.entity.Activity;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/11 14:35
 */
public interface ActivityMapper {

    /**
     * 查询当前活动信息
     *
     * @return
     */
    public Activity queryActivity();

    /**
     * 更新信息
     *
     * @param activity
     */
    public void update(Activity activity);


    /**
     * 设置开放
     *
     * @param code
     */
    public void setOpenCode(Integer code);

}
