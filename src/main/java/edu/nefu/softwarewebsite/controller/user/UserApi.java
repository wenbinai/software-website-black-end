package edu.nefu.softwarewebsite.controller.user;

import edu.nefu.softwarewebsite.pojo.User;
import edu.nefu.softwarewebsite.service.UserService;
import edu.nefu.softwarewebsite.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return userService.login(user);
    }
}
