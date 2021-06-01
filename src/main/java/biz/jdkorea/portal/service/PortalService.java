package biz.jdkorea.portal.service;

import java.util.Map;

public interface PortalService {

    public Map<String, Object> getBoardInfo(Map<String, Object> request) throws Exception;

    public boolean setBoardInfo(Map<String, Object> request) throws Exception;

}
