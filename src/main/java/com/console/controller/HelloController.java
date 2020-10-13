package com.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/7 14:04
 */
@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("name", "ZhangSan");
        map.put("age", 25);
        map.put("mail", "console@qq.como");
        map.put("lists", Arrays.asList("zhansna", "lisi", "tom"));
        return "success";
    }
}
