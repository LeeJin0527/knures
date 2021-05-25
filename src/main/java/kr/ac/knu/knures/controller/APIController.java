package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.api.response.CommonResponse;
import kr.ac.knu.knures.dto.WishListDTO;
import kr.ac.knu.knures.service.MemberService;
import kr.ac.knu.knures.service.WishListService;
import kr.ac.knu.knures.session.LoginInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class APIController {
    private final MemberService memberService;
    private final WishListService wishListService;

    @Resource
    private LoginInfo loginInfo;

    @PostMapping("/toggleWish")
    public ResponseEntity<CommonResponse> toggleWish(Long mno, Boolean wish) {
        String email = loginInfo.getEmail();

        if (wish) { // 토글 끄기. 삭제
            wishListService.delete(email, mno);
        } else { // 토글 켜기. 추가
            WishListDTO dto = WishListDTO.builder().email(email).mno(mno).build();
            wishListService.register(dto);
        }

        return new ResponseEntity<>(CommonResponse.builder().msg("OK").build(), HttpStatus.OK);
    }
}
