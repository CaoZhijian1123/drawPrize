package com.console.controller;

import com.console.entity.Activity;
import com.console.entity.User;
import com.console.log.LogUtil;
import com.console.service.ActivityService;
import com.console.service.UserService;
import com.console.service.handler.UserAddResultHandler;
import com.console.util.UuidUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/10 16:32
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;


    @PostMapping({"/user", "/user/"})
    public String addUser(User user, Model model) {
        model.addAttribute("activity", activityService.getActivity());

        if (!activityService.isOpen()) {
            model.addAttribute("msg", "活动关闭中，无法参加！");
            return "user_form";
        }

        user.setUuid(UuidUtil.getUuid12());


        UserAddResultHandler handler = userService.add(user);
        if (handler.isOK()) {
            model.addAttribute("user", user);

            LogUtil.getLogger(this.getClass()).info("new user " + user);

            return "user_add_success";
        } else {
            model.addAttribute("msg", handler.getMessage());
            return "user_form";
        }


    }

    @GetMapping("/user")
    public String getUserForm(Model model) {

        Activity activity = activityService.getActivity();
        model.addAttribute("activity", activity);
        return "user_form";
    }

}
