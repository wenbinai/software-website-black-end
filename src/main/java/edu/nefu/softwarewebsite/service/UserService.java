package edu.nefu.softwarewebsite.service;

import edu.nefu.softwarewebsite.pojo.User;
import edu.nefu.softwarewebsite.util.ResponseResult;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpResponse;

public interface UserService {
    ResponseResult login(User user, HttpServletResponse response);
}
