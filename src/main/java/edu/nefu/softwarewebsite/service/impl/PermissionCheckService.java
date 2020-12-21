package edu.nefu.softwarewebsite.service.impl;

import edu.nefu.softwarewebsite.util.Constants;
import edu.nefu.softwarewebsite.util.CookieUtil;
import edu.nefu.softwarewebsite.util.TextUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service("permission")
public class PermissionCheckService {
    // 是否为管理员
    public boolean adminPermission() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String cookie = CookieUtil.getCookie(request, Constants.Cookie.KEY);
        System.out.println("cookie ==>" + cookie);
        if (TextUtil.isEmpty(cookie)) {
            return false;
        }
        return true;
    }
}
