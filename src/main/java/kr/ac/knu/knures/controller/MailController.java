package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.api.response.CommonResponse;
import kr.ac.knu.knures.dto.MailDTO;
import kr.ac.knu.knures.service.MailService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @PostMapping("/mail")
    public ResponseEntity<CommonResponse> execMail(MailDTO mailDto) {

        mailService.mailSend(mailDto);
        return new ResponseEntity<>(CommonResponse.builder().msg("OK").build(), HttpStatus.OK);
    }

    @PostMapping("/check_mail")
    public ResponseEntity<CommonResponse> check(String email, String num) {
        if (mailService.checkNum(email, num)) {
            return new ResponseEntity<>(CommonResponse.builder().msg("OK").build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(CommonResponse.builder().msg("failed").build(), HttpStatus.BAD_REQUEST);
        }
    };


}