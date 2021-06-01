package biz.jdkorea.portal.web;

import biz.jdkorea.portal.service.PortalService;
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
public class RestPortalController {

    private final PortalService portalService;

    @PostMapping("/getBoardInfo")
    public Map<String, Object> getBoardInfo(@RequestBody Map<String, Object> request) throws Exception {
        return portalService.getBoardInfo(request);
    }

    @PostMapping("/setBoardInfo")
    public ResponseEntity<Boolean> setBoardInfo(@RequestBody Map<String, Object> request) throws Exception {
        boolean result = portalService.setBoardInfo(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/updateBoardInfo")
    public ResponseEntity<Boolean> updateBoardInfo(@RequestBody Map<String, Object> request) throws Exception {
        boolean result = portalService.updateBoardInfo(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/deleteBoardInfo")
    public ResponseEntity<Boolean> deleteBoardInfo(@RequestBody Map<String, Object> request) throws Exception {
        boolean result = portalService.deleteBoardInfo(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
