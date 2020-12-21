package edu.nefu.softwarewebsite.service.impl;

import edu.nefu.softwarewebsite.dao.UserDao;
import edu.nefu.softwarewebsite.pojo.User;
import edu.nefu.softwarewebsite.service.UserService;
import edu.nefu.softwarewebsite.util.Constants;
import edu.nefu.softwarewebsite.util.CookieUtil;
import edu.nefu.softwarewebsite.util.ResponseResult;
import edu.nefu.softwarewebsite.util.TextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseResult login(User user, HttpServletResponse response) {
        // 检验参数
        if (user == null) {
            return ResponseResult.failResponse()
                    .setMessage("用户不能为空");
        }

        if (TextUtil.isEmpty(user.getName())) {
            return ResponseResult.failResponse()
                    .setMessage("用户姓名不能为空");
        }
        if (TextUtil.isEmpty(user.getPassword())) {
            return ResponseResult.failResponse()
                    .setMessage("用户密码不能为空");
        }
        // 通过用户名查找用户
        User userFromDB = userDao.findOneByName(user.getName());
        if (userFromDB == null) {
            return ResponseResult.failResponse()
                    .setMessage("用户名不存在");
        }
        System.out.println("userFromDB==>" + userFromDB);
        System.out.println("user password==>" + user.getPassword());
        // TODO: 不以明文存密码 对比密码
        if (!userFromDB.getPassword().equals(user.getPassword())) {
            return ResponseResult.failResponse()
                    .setMessage("用户名或密码错误");
        }
        // 生成cookie
        CookieUtil.setUpCookie(response, Constants.Cookie.KEY, "admin");
        return ResponseResult.successResponse()
                .setMessage("登陆成功");
    }
}
