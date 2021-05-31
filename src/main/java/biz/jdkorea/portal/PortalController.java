package biz.jdkorea.portal;

import biz.jdkorea.com.common.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PortalController {

    private final Logger logger = LoggerFactory.getLogger(PortalController.class);
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
