package biz.jdkorea.login.service.impl;

import biz.jdkorea.com.common.CommonUtil;
import biz.jdkorea.login.repository.User;
import biz.jdkorea.login.repository.UserRepository;
import biz.jdkorea.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final CommonUtil commonUtil;
    private final UserRepository userRepository;

    @Override
    public boolean loginCheck(Map<String, Object> request) throws Exception {
        String id = request.get("id").toString();
        String password = request.get("password").toString();
        id = commonUtil.stripScriptTagsAndFunctions(id);
        String hashPassword = commonUtil.passwordToHashPassword512(password);
        User user = userRepository.findUserById(id);
        if (user != null && hashPassword.equalsIgnoreCase(user.getPassword())) {
            request.put("loginUser", true);
            return true;
        }

        return false;
    }

    @Override
    public boolean setUser(Map<String, Object> request) throws Exception {
        String id;
        String password;
        String name;
        if (request.get("id") != null && request.get("name") != null && request.get("password") != null) {
            id = request.get("id").toString();
            password = request.get("password").toString();
            password = commonUtil.passwordToHashPassword512(password);
            name = request.get("name").toString();
        } else {
            log.error("some data(id, password, name) is null!");
            return false;
        }

        String email = request.get("email").toString();
        String phoneNumber = request.get("phoneNumber").toString();
        String saveDate = commonUtil.getNowDate("yyyyMMDDHHmmss");
        User user = User.builder().id(id).name(name).password(password)
                        .phoneNumber(phoneNumber).email(email).saveDate(saveDate)
                        .build();
        User saveUser = userRepository.save(user);
        return saveUser.getId().equalsIgnoreCase(user.getId());
    }
}
