package com.console.controller;

import com.console.log.LogUtil;
import com.console.model.Quote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.jws.WebParam;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.alibaba.fastjson.JSON;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/11 20:46
 */
@Controller
public class TimerController {

    @GetMapping("/time")
    public String gotoTimer(Model model) {
        String str = "";
        Quote quote = null;
        try {
            quote = parse(getQuoteString());
            str = quote.getData().getContent() + "    ————" + quote.getData().getAuthor();
        } catch (UnsupportedEncodingException e) {

            LogUtil.getLogger(this.getClass()).error(e.getMessage());
        }

        System.out.println(str);
        if (str == null || "".equals(str)) {
            str = "谁对时间最吝啬，时间对谁越慷慨。要时间不辜负你，首先你要不辜负时间。放弃时间的人，时间也放弃他。";
        }
        LogUtil.getLogger(this.getClass()).info("get quote:" + str);

        model.addAttribute("quote", str);
        return "time";
    }

    private String getQuoteString() throws UnsupportedEncodingException {
        String param = "{\"url\":\"中文\"}";
        param = URLEncoder.encode(param, "UTF-8");
        PrintWriter out = null;
        BufferedReader in = null;
//        String result = "";
        StringBuilder result = new StringBuilder();
        try {
            URL realUrl = new URL("https://v1.alapi.cn/api/mingyan?typeid=35");
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            //解析json对象

        } catch (Exception e) {

            LogUtil.getLogger(this.getClass()).error(e.getMessage());
        }

        return result.toString();
    }

    private Quote parse(String str) {
        Quote parse = JSON.parseObject(str, Quote.class);
        return parse;
    }
}
