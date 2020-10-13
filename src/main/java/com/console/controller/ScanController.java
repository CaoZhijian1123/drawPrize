package com.console.controller;

import com.console.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/12 13:14
 */
@Controller
public class ScanController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/scan")
    public String getScanImg(Model model) {

        model.addAttribute("codeLink", activityService.getActivity().getCodeLink());
        return "scan";
    }
}
