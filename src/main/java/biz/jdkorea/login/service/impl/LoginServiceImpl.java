package biz.jdkorea.login.service.impl;

import biz.jdkorea.com.comm.CommonUtil;
import biz.jdkorea.login.repository.User;
import biz.jdkorea.login.repository.UserRepository;
import biz.jdkorea.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final CommonUtil commonUtil;
    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public boolean loginCheck(Map<String, Object> request) throws Exception {
        boolean check = false;

        String id = request.get("id").toString();
        String password = request.get("password").toString();
        id = commonUtil.stripScriptTagsAndFunctions(id);
        String hashPassword = commonUtil.passwordToHashPassword512(password);

        User user = userRepository.findUserById(id);
        if (user != null && hashPassword.equalsIgnoreCase(user.getPassword())) {
            check = true;
        }

        request.put("loginUser", check);
        return check;
    }

}
