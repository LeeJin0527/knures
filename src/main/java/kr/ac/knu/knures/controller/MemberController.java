package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.dto.MemberDTO;
import kr.ac.knu.knures.dto.MerchandiseDTO;
import kr.ac.knu.knures.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MemberController {
    private final MemberService service;

    @GetMapping("/register")
    public String dispRegister() {
        return "register_member";
    }

    @PostMapping("/register")
    public String doRegister(MemberDTO memberDTO) {
        service.register(memberDTO);
        return "redirect:/login";
    }


}
