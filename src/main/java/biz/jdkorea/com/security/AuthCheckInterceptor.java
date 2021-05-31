package biz.jdkorea.com.security;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Component
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            moveLoginPage(response);
            return false;
        }

        boolean checkCookie = Arrays.stream(cookies).allMatch(cookie -> cookie.getName().equalsIgnoreCase("loginCookie"));
        if (!checkCookie) {
            moveLoginPage(response);
            return false;
        }

        return true;
    }

    private void moveLoginPage(HttpServletResponse response) throws Exception {
        response.sendRedirect("/login");
    }
}
