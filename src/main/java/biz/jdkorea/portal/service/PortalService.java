package biz.jdkorea.portal.service;

import java.util.Map;

public interface PortalService {

    Map<String, Object> getBoardInfo(Map<String, Object> request) throws Exception;

    boolean setBoardInfo(Map<String, Object> request) throws Exception;

    boolean updateBoardInfo(Map<String, Object> request) throws Exception;

    boolean deleteBoardInfo(Map<String, Object> request) throws Exception;

}
