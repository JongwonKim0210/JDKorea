package biz.jdkorea.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {

    /**
     * Desc : Main 페이지로의 이동을 처리한다.
     * @return 메인(Index) 페이지
     */
    @GetMapping(value = {"/", "/home", "/main"})
    public String getIndexPage() {
        return "Index";
    }

    /**
     * Desc : About Title 페이지를 호출한다.
     * @return About Title 화면
     */
    @GetMapping(value = {"/about", "/about/title"})
    public String getAboutMainPage() {
        return null;
    }

    /**
     * Desc : About Come 페이지를 호출한다.
     * @return About Come 화면
     */
    @GetMapping("/about/come")
    public String getAboutComePage() {
        return null;
    }

    @GetMapping(value = {"/business"})
    public String getBusinessMainPage() {
        return null;
    }

    @GetMapping(value = {"/gallery"})
    public String getGalleryMainPage() {
        return null;
    }

    @GetMapping(value = {"/online"})
    public String getOnlineMainPage() {
        return null;
    }

    @GetMapping(value = {"/customer"})
    public String getCustomerMainPage() {
        return null;
    }
}
