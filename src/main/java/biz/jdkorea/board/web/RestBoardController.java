package biz.jdkorea.board.web;

import biz.jdkorea.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RestBoardController {

    private final BoardService boardService;

    @PostMapping("/getBoardInfo")
    public Map<String, Object> getBoardInfo(@RequestBody Map<String, Object> request) throws Exception {
        return boardService.getBoardInfo(request);
    }

    @PostMapping("/setBoardInfo")
    public ResponseEntity<Boolean> setBoardInfo(@RequestBody Map<String, Object> request) throws Exception {
        boolean result = boardService.setBoardInfo(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/updateBoardInfo")
    public ResponseEntity<Boolean> updateBoardInfo(@RequestBody Map<String, Object> request) throws Exception {
        boolean result = boardService.updateBoardInfo(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/deleteBoardInfo")
    public ResponseEntity<Boolean> deleteBoardInfo(@RequestBody Map<String, Object> request) throws Exception {
        boolean result = boardService.deleteBoardInfo(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
