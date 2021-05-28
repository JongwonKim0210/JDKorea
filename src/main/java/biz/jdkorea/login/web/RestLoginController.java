package biz.jdkorea.login.web;

import biz.jdkorea.com.comm.CommonUtil;
import biz.jdkorea.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
            logger.info("cookie make start");
            String loginCookie = commonUtil.makeCookieValue(request);
            Cookie cookie = new Cookie("loginCookie", loginCookie);
            cookie.setSecure(true);
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
