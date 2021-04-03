package biz.jdkorea.web.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String getIndexPage() {
        logger.info("request get Index Page...");

        logger.info("making Index Page Complete!");
        return "Index";
    }

}
