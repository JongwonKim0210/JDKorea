package biz.jdkorea.portal;

import biz.jdkorea.com.comm.CommonUtil;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

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
