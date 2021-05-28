package biz.jdkorea.com.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LetController {

    private static final Logger logger = LoggerFactory.getLogger(LetController.class);

    @GetMapping("/adminPage")
    public String adminPage() {

        return "/admin/adminPage";
    }

}
