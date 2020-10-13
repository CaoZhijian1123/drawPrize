package com.console.service;

import com.console.entity.Activity;
import com.console.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/11 14:41
 */

@SuppressWarnings("ALL")
@Service
public class ActivityService {

    @Autowired
    private ActivityMapper mapper;


    public Activity getActivity() {
        return mapper.queryActivity();
    }


    /**
     * 更新活动信息
     *
     * @param activity
     */
    public void update(Activity activity) {
        mapper.update(activity);
    }

    /**
     * 开放活动
     */
    public void openActivity() {
        mapper.setOpenCode(1);
    }

    /**
     * 关闭活动
     */
    public void closeActivity() {
        mapper.setOpenCode(0);
    }

    /**
     * 查看活动是否开放
     *
     * @return true表示活动开放，false表示活动不开放
     */
    public Boolean isOpen() {
        Short open = mapper.queryActivity().getOpen();
        if (open == 0) {
            return false;
        } else {
            return true;
        }
    }

}
