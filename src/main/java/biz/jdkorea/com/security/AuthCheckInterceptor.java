package biz.jdkorea.com.security;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        boolean checkCookie = false;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equalsIgnoreCase("loginCookie")) {
                checkCookie = true;
                break;
            }
        }

        if (!checkCookie) {
            response.sendRedirect("/login");
        }

        return checkCookie;
    }
}
