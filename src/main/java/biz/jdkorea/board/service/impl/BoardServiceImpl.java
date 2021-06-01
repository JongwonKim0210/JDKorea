package biz.jdkorea.board.service.impl;

import biz.jdkorea.com.common.CommonUtil;
import biz.jdkorea.board.repository.Board;
import biz.jdkorea.board.repository.BoardRepository;
import biz.jdkorea.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

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
        authorPassword = commonUtil.passwordToHashPassword256(authorPassword);
        String saveDate = commonUtil.getNowDate("yyyyMMDDHHmmss");
        Board board = Board.builder().boardType(boardType).title(title).content(content)
                           .authorName(authorName).authorPassword(authorPassword).saveDate(saveDate)
                           .build();
        Board newBoard = boardRepository.save(board);
        return newBoard.getSaveDate().equalsIgnoreCase(saveDate);
    }

    @Override
    public boolean updateBoardInfo(Map<String, Object> request) throws Exception {
        long boardId = 0;
        String authorPassword = "";
        String title = "";
        String content = "";
        if (request.get("boardId") != null && request.get("authorPassword") != null
            && request.get("title") != null && request.get("content") != null) {
            boardId = (long) request.get("boardId");
            authorPassword = request.get("authorPassword").toString();
            authorPassword = commonUtil.passwordToHashPassword256(authorPassword);
            title = request.get("title").toString();
            content = request.get("content").toString();
        }

        Board board = boardRepository.findBoardById(boardId);
        if (board == null) {
            return false;
        }

        if (!authorPassword.equalsIgnoreCase(board.getAuthorPassword())) {
            return false;
        }

        board = Board.builder().id(boardId).title(title).content(content).build();
        Board newBoard = boardRepository.save(board);
        return newBoard.getId() == board.getId();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean deleteBoardInfo(Map<String, Object> request) {
        List<Long> boardIds = new ArrayList<>();
        if (request.get("boardIds") != null) {
            boardIds = (List<Long>) request.get("boardIds");
        }

        if (boardIds.size() <= 0) {
            return false;
        } else if (boardIds.size() == 1) {
            deleteBoard(boardIds.get(0));
        } else {
            for (long boardId : boardIds) {
                deleteBoard(boardId);
            }
        }

        return true;
    }
    private void deleteBoard(long boardId) {
        boardRepository.deleteById(boardId);
    }
}
