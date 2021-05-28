package biz.jdkorea.login.service.impl;

import biz.jdkorea.comm.CommonUtil;
import biz.jdkorea.login.repository.User;
import biz.jdkorea.login.repository.UserRepository;
import biz.jdkorea.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final CommonUtil commonUtil;
    private final UserRepository userRepository;

    @Override
    public boolean loginCheck(Map<String, Object> request) throws Exception {
        boolean check = false;

        String id = request.get("id").toString();
        String password = request.get("password").toString();
        id = commonUtil.stripScriptTagsAndFunctions(id);

        User user = userRepository.findUserById(id);
        if (user != null) {
            String hashPassword = commonUtil.passwordToHashPassword(password);

            if (hashPassword.equalsIgnoreCase(user.getPassword())) {
                check = true;
            }
        }

        return check;
    }
}
