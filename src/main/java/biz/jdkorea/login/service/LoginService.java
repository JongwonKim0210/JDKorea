package biz.jdkorea.login.service;

import java.util.Map;

public interface LoginService {

    boolean loginCheck(Map<String, Object> request) throws Exception;

    boolean setUser(Map<String, Object> request) throws Exception;
}
