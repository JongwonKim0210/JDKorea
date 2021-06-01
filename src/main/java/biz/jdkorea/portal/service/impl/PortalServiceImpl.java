package biz.jdkorea.portal.service.impl;

import biz.jdkorea.com.common.CommonUtil;
import biz.jdkorea.portal.repository.Board;
import biz.jdkorea.portal.repository.BoardRepository;
import biz.jdkorea.portal.service.PortalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class PortalServiceImpl implements PortalService {

    private final CommonUtil commonUtil;
    private final BoardRepository boardRepository;

    @Override
    public Map<String, Object> getBoardInfo(Map<String, Object> request) throws IllegalArgumentException {

        String boardType = request.get("boardType").toString();
        int pageNumber = Integer.parseInt(request.get("pageNumber").toString());
        log.debug("request BoardType : " + boardType + " and pageNumber : " + pageNumber);

        Map<String, Object> result = new HashMap<>();
        List<?> resultList = switchDataSource(boardType, pageNumber);
        result.put("resultList", resultList);
        return result;
    }
    private List<?> switchDataSource(String boardType, int pageNumber) throws IllegalArgumentException {
        switch (boardType) {
            case "free" :
                return new ArrayList<>();
            case "notice" :
                return new LinkedList<>();
            case "gallery" :
                return new Vector<>();
            default:
                throw new IllegalArgumentException("can not find boardType");
        }
    }

    @Override
    public boolean setBoardInfo(Map<String, Object> request) throws Exception {
        String boardType = "";
        String title = "";
        String content = "";
        String authorName = "";
        if (request.get("boardType") != null && request.get("title") != null
            && request.get("content") != null  && request.get("authorName") != null ) {
            boardType = request.get("boardType").toString();
            title = request.get("title").toString();
            content = request.get("content").toString();
            authorName = request.get("authorName").toString();
            log.debug("insert boardType : " + boardType);
        }

        String authorPassword = request.get("authorPassword").toString();
        String saveDate = commonUtil.getNowDate("yyyyMMDDHHmmss");
        Board board = Board.builder().boardType(boardType).title(title).content(content)
                           .authorName(authorName).authorPassword(authorPassword).saveDate(saveDate)
                           .build();
        Board newBoard = boardRepository.save(board);
        return newBoard.getSaveDate().equalsIgnoreCase(saveDate);
    }
}
