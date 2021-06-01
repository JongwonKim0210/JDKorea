package biz.jdkorea.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestPageController {

    @GetMapping("/TestPage")
    public String getTestPage() {
        return "TestPage";
    }

}
