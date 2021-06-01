package biz.jdkorea.portal.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalController {

    /**
     * Desc : Main 페이지로의 이동을 처리한다.
     * @return 메인(Index) 페이지
     */
    @GetMapping(value = {"/", "/home", "/main"})
    public String getIndexPage() {
//        return "Index";
        return "/login/Login";
    }

    /**
     * Desc : 요청한 페이지 화면을 호출한다.
     * @param model 요청한 페이지 타입을 넘겨준다
     * @return 게시판 main 화면
     */
    @GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("boardType", "about");
        return null;
    }

    /**
     * Desc : 요청한 페이지 화면을 호출한다.
     * @param model 요청한 페이지 타입을 넘겨준다
     * @return 게시판 main 화면
     */
    @GetMapping("/business")
    public String getBusinessPage(Model model) {
        model.addAttribute("boardType", "business");
        return null;
    }

    /**
     * Desc : 요청한 페이지 화면을 호출한다.
     * @param model 요청한 페이지 타입을 넘겨준다
     * @return 게시판 main 화면
     */
    @GetMapping("/gallery")
    public String getGalleryPage(Model model) {
        model.addAttribute("boardType", "gallery");
        return null;
    }

    /**
     * Desc : 요청한 페이지 화면을 호출한다.
     * @param model 요청한 페이지 타입을 넘겨준다
     * @return 게시판 main 화면
     */
    @GetMapping("/online")
    public String getOnlinePage(Model model) {
        model.addAttribute("boardType", "online");
        return null;
    }

    /**
     * Desc : 요청한 페이지 화면을 호출한다.
     * @param model 요청한 페이지 타입을 넘겨준다
     * @return 게시판 main 화면
     */
    @GetMapping("/customer")
    public String getCustomerPage(Model model) {
        model.addAttribute("boardType", "customer");
        return null;
    }
}
