package biz.jdkorea.login.web;

import biz.jdkorea.com.common.CommonUtil;
import biz.jdkorea.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestLoginController {

    private static final Logger logger = LoggerFactory.getLogger(RestLoginController.class);
    private final LoginService loginService;
    private final CommonUtil commonUtil;

    @PostMapping("/loginCheck")
    public ResponseEntity<Boolean> loginCheck(@RequestBody Map<String, Object> request, HttpServletResponse response) throws Exception {
        boolean result = loginService.loginCheck(request);
        if (result) {
            String loginCookie = commonUtil.makeCookieValue(request);
            Cookie cookie = new Cookie("loginCookie", loginCookie);
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public ResponseEntity<Boolean> logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equalsIgnoreCase("loginCookie")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    return new ResponseEntity<>(true, HttpStatus.OK);
                }
            }
        }

        return new ResponseEntity<>(false, HttpStatus.OK);
    }
}
