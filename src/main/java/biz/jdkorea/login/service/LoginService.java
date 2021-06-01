package biz.jdkorea.login.service;

import java.util.Map;

public interface LoginService {

    public boolean loginCheck(Map<String, Object> request) throws Exception;

    public boolean setUser(Map<String, Object> request) throws Exception;
}
