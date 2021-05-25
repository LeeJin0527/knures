package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.dto.CommunityBoardDTO;
import kr.ac.knu.knures.service.CommunityBoardService;
import kr.ac.knu.knures.service.MemberService;
import kr.ac.knu.knures.session.LoginInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class ViewController {
    private final CommunityBoardService communityBoardService;
    private final MemberService  memberService;

    @Resource
    private LoginInfo loginInfo;

    @GetMapping({"/main", "/index", "/board", "/", "/home"})
    public String board(Model model){
       // List<CommunityBoardDTO> list = communityBoardService.getListAll();
        //model.addAttribute("dto", list);
        return "index";
    }

    @GetMapping("/login")
    public String index_login(){
        String loginEmail = loginInfo.getEmail();
        if (loginEmail != null && !loginEmail.isEmpty()) {
            return "redirect:/merchandise/list";
        }

        log.info("index_login page!!");
        return "login";
    }


    @PostMapping("/login")
    public String doLogin(String email, String password){
        log.info("email:"+email+" password:"+password);

        if (memberService.checkLoginSuccess(email, password)) {
            loginInfo.setEmail(email);

            return "redirect:/merchandise/list";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String doLogout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
