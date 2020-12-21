package edu.nefu.softwarewebsite.service;

import edu.nefu.softwarewebsite.pojo.User;
import edu.nefu.softwarewebsite.util.ResponseResult;

public interface UserService {
    ResponseResult login(User user);
}
