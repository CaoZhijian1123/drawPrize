package com.console.mapper;

import com.console.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/7 19:48
 */

public interface UserMapper {
    /**
     * 用户总数
     *
     * @return
     */
    Integer userCount();

    /**
     * 通过id删除用户
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    User queryById(Integer id);

    /**
     * 修改用户信息
     *
     * @param user
     */
    void update(User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    public List<User> queryAll();

    /**
     * 添加新的用户
     *
     * @param user
     */
    public void add(User user);

    /**
     * 查询电话或者邮件重复的用户
     *
     * @param user
     * @return
     */
    public List<User> getByTelOrMail(User user);
}
