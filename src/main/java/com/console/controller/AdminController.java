package com.console.controller;

import com.console.entity.User;
import com.console.log.LogUtil;
import com.console.service.ActivityService;
import com.console.service.AdminService;
import com.console.service.UserService;
import com.console.service.handler.UserAddResultHandler;
import com.console.util.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author caozj, (Zhijian Cao) <br>
 * Beijing, China <br>
 * email <a href="mailto:caozj17@mails.tsinghua.edu.cn">caozj17@mails.tsinghua.edu.cn</a>
 * @version 1.0
 * @since 2020/10/11 15:29
 */
@SuppressWarnings("ALL")
@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private AdminService adminService;


    @GetMapping({"/admin/", "/admin", "/admin/login", "/admin/login.html"})
    public String getLogin() {
        return "login";
    }

    @PostMapping("/admin/login")
    public String adminLogin(String username, String password, HttpServletRequest request) {


        String message = "";
        if (username == null || password == null) {
            request.setAttribute("message", "用户名或密码为空");
            return "login";
        }

        String pwd = adminService.getPwd(username);

        if (StringUtils.isEmpty(pwd)) {
            request.setAttribute("message", "账户不存在");
            return "login";
        }

        if (pwd.equals(password)) {
            request.getSession().setAttribute("user", username);
            LogUtil.getLogger(this.getClass()).info("admin login, name=" + username);
            return "redirect:/admin/dashboard";

        } else {
            request.setAttribute("message", "密码错误");
            LogUtil.getLogger(this.getClass()).info(username + " try to login with a wrong pwd");
            return "login";
        }
    }


    @GetMapping("/admin/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("risk", 65);
        model.addAttribute("attendance", 85);
        model.addAttribute("speed", 75);
        model.addAttribute("status", 78);

        //用户总数
        model.addAttribute("count", userService.getUsersCount());


        return "dashboard";
    }

    @GetMapping("/admin/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.queryAll();
        model.addAttribute("users", users);
        return "user/list";
    }

    /**
     * 获取管理员添加用户的界面
     *
     * @param model
     * @return
     */
    @GetMapping("/admin/user")
    public String getUser(Model model) {

        return "user/addUserByAdmin";
    }

    /**
     * 管理员添加用户
     *
     * @param model
     * @param user
     * @return
     */
    @PostMapping("/admin/user")
    public String addUser(User user, Model model) {

        //管理员添加用户可以在活动关闭的时候添加
        user.setUuid(UuidUtil.getUuid12());


        UserAddResultHandler handler = userService.add(user);
        if (handler.isOK()) {
            model.addAttribute("user", user);
            LogUtil.getLogger(this.getClass()).info("new user " + user);
            return "redirect:/admin/users";
        } else {
            model.addAttribute("msg", handler.getMessage());
            return "user/addUserByAdmin";
        }
    }


    /**
     * 获取修改用户页面，和添加用户使用同一个页面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/admin/user/{id}")
    public String toModifyUser(@PathVariable Integer id, Model model) {
        User user = userService.queryById(id);
        model.addAttribute("user", user);

        return "user/addUserByAdmin";
    }


    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @PutMapping("/admin/user")
    public String modifyUser(User user) {
        userService.update(user);

        LogUtil.getLogger(this.getClass()).info("update user " + user);
        return "redirect:/admin/users";
    }


    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    @DeleteMapping("/admin/user/{id}")
    public String deleteUser(@PathVariable Integer id) {
        LogUtil.getLogger(this.getClass()).info("delete user, id=" + id);
        userService.deleteById(id);
        return "redirect:/admin/users";
    }
}
