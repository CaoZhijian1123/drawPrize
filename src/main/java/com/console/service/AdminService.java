package com.console.service;

import com.console.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/12 13:37
 */
@SuppressWarnings("ALL")
@Service
public class AdminService {

    @Autowired
    private AdminMapper mapper;


    public String getPwd(String name) {
        return mapper.getPwd(name);
    }
}
