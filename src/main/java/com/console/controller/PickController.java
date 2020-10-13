package com.console.controller;

import com.console.entity.User;
import com.console.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;
import java.util.List;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/10 12:31
 */

@SuppressWarnings("ALL")
@Controller
public class PickController {

    @Autowired
    private UserService userService;


    @GetMapping({"/pick", "/pick.html"})

    public String getIndex(Model model) {

        List<User> users = userService.queryAll();

        //将id格式化为固定宽度编号
        DecimalFormat df = new DecimalFormat("00000");
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        if (users != null) {
            for (User user : users) {
                builder.append("\"").append(df.format(user.getId())).append("\"").append(",")
                        .append("\"").append(user.getName().charAt(0)).append("\"").append(",")
                        .append("\"").append(user.getName()).append("\"").append(",")
                        .append("\"").append(user.getStudentId()).append("\"").append(",");
            }

        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");

        model.addAttribute("userStr", builder.toString());
        return "pick";
    }
}
