package biz.jdkorea.portal.web;

import biz.jdkorea.com.common.CommonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PortalController {

    private CommonUtil commonUtil;

    @GetMapping(value = {"/", "/home", "/main"})
    public String getIndexPage() {
//        return "Index";
        return "/login/Login";
    }

    @GetMapping("/TestPage")
    public String getTestPage() {
        return "TestPage";
    }

}
