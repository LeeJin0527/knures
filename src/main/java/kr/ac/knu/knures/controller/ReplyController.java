package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.api.response.CommonResponse;
import kr.ac.knu.knures.dto.CommunityBoardReplyDTO;
import kr.ac.knu.knures.dto.MerchandiseDTO;
import kr.ac.knu.knures.dto.ReplyDTO;
import kr.ac.knu.knures.service.MerchandiseService;
import kr.ac.knu.knures.service.ReplyService;
import kr.ac.knu.knures.session.LoginInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {
    private final ReplyService service;

    @Resource
    private LoginInfo loginInfo;

    @GetMapping("/modify")
    public String reply_modify(Long rno, Model model) {
        ReplyDTO dto = service.getOne(rno);
        model.addAttribute("merchandise", dto);
        return "redirect:/merchandise/detail";
    }

    @PostMapping("/register")
    public ResponseEntity<CommonResponse> register(ReplyDTO dto) {
        dto.setReplierEmail(loginInfo.getEmail());
        service.register(dto);

        return new ResponseEntity<>(CommonResponse.builder().msg("OK").build(), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<CommonResponse> reply_delete(Long rno) {
        service.delete(rno);

        return new ResponseEntity<>(CommonResponse.builder().msg("OK").build(), HttpStatus.OK);
    }

}
