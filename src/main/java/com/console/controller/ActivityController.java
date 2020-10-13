package com.console.controller;

import com.console.entity.Activity;
import com.console.log.LogUtil;
import com.console.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/11 18:58
 */
@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    /**
     * 获取活动信息
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/activity")
    public String getActivity(Model model) {
        model.addAttribute("activity", activityService.getActivity());

        return "activity/activity";
    }

    /**
     * 获取活动信息
     *
     * @param activity
     * @return
     */
    @PostMapping("/admin/activity")
    public String editActivity(Activity activity) {

        activityService.update(activity);
        LogUtil.getLogger(this.getClass()).info("update activity to");
        return "redirect:/admin/activity";
    }

    @GetMapping("/admin/activity/{code}")
    public String switchActivity(@PathVariable Short code) {
        if (code == 0) {
            activityService.closeActivity();
            LogUtil.getLogger(this.getClass()).info("close activity");

        } else {
            activityService.openActivity();
            LogUtil.getLogger(this.getClass()).info("open activity");
        }
        return "redirect:/admin/activity";

    }

    /**
     * 转到修改活动信息页面
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/activity/edit")
    public String toEdit(Model model) {
        model.addAttribute("activity", activityService.getActivity());

        return "activity/activity_edit";
    }

}
