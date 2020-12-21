package edu.nefu.softwarewebsite.controller;

import edu.nefu.softwarewebsite.util.ResponseResult;
import edu.nefu.softwarewebsite.util.ResponseStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {
    @RequestMapping(value = "/403", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    @ResponseBody
    public ResponseResult page403() {
        ResponseResult responseResult = new ResponseResult(ResponseStatus.ACCOUNT_NOT_LOGIN);
        return responseResult;
    }
}
