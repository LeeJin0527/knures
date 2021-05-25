package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.api.response.CommonResponse;
import kr.ac.knu.knures.dto.CommunityBoardReplyDTO;
import kr.ac.knu.knures.dto.ReplyDTO;
import kr.ac.knu.knures.service.CommunityBoardReplyService;
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
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/communityReply")
public class CommunityBoardReplyController {
    private final CommunityBoardReplyService service;

    @Resource
    private LoginInfo loginInfo;

    @PostMapping("/register")
    public ResponseEntity<CommonResponse> register(CommunityBoardReplyDTO dto) {
        dto.setReplierEmail(loginInfo.getEmail());
        service.register(dto);

        return new ResponseEntity<>(CommonResponse.builder().msg("OK").build(), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<CommonResponse> reply_delete(Long bno) {
        service.delete(bno);

        return new ResponseEntity<>(CommonResponse.builder().msg("OK").build(), HttpStatus.OK);
    }
}
