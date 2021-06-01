package biz.jdkorea.portal.web;

import biz.jdkorea.portal.service.PortalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

}
