package biz.jdkorea.login.web;

import biz.jdkorea.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestLoginController {

    private static final Logger logger = LoggerFactory.getLogger(RestLoginController.class);
    private final LoginService loginService;

    @PostMapping("/loginCheck")
    public ResponseEntity<Boolean> loginCheck(@RequestBody Map<String, Object> request) throws Exception {
        boolean result = loginService.loginCheck(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
