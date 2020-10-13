package com.console.service;

import com.console.entity.User;
import com.console.mapper.UserMapper;
import com.console.service.handler.UserAddResultHandler;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/7 20:03
 */


@SuppressWarnings("all")
@Transactional
@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    public Integer getUsersCount() {
        return mapper.userCount();
    }

    /**
     * 删除用户
     *
     * @param id
     */
    public void deleteById(Integer id) {
        mapper.deleteById(id);
    }

    /**
     * 更新用户信息
     *
     * @param user
     */
    public void update(User user) {
        mapper.update(user);
    }

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    public User queryById(Integer id) {
        return mapper.queryById(id);
    }


    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> queryAll() {
        List<User> users = mapper.queryAll();
        return users;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return 返回添加状态，如果电话或者邮件被注册，会返回错误信息，不会抛出异常
     */
    public UserAddResultHandler add(User user) {

        UserAddResultHandler handler = new UserAddResultHandler();
        handler.setOK(false);

        if (StringUtils.isEmpty(user.getName())) {
            handler.setMessage("用户名为空");
            return handler;
        }
        if (StringUtils.isEmpty(user.getTel())) {
            handler.setMessage("电话号码为空");
            return handler;
        }
        if (StringUtils.isEmpty(user.getStudentId())) {
            handler.setMessage("学工号为空");
            return handler;
        }
        if (StringUtils.isEmpty(user.getMail())) {
            handler.setMessage("邮件为空");
            return handler;
        }


        List<User> users = mapper.getByTelOrMail(user);
        if (users != null && users.size() != 0) {
            handler.setOK(false);
            handler.setMessage("电话或邮件已被注册");
            return handler;
        }


        mapper.add(user);
        handler.setOK(true);
        handler.setMessage("添加成功");
        return handler;
    }


}
