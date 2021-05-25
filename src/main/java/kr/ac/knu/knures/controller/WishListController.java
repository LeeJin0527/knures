package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.dto.MerchandiseDTO;
import kr.ac.knu.knures.dto.WishListDTO;
import kr.ac.knu.knures.service.MemberService;
import kr.ac.knu.knures.service.MerchandiseService;
import kr.ac.knu.knures.service.WishListService;
import kr.ac.knu.knures.session.LoginInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/wish")
@Log4j2
public class WishListController {
    private final MerchandiseService merchandiseService;
    private final MemberService memberService;
    private final WishListService wishListService;

    @Resource
    private LoginInfo loginInfo; //login 정보

    @GetMapping("/wishlist")
    public String wishList(Model model){
        if (loginInfo == null || loginInfo.getEmail() == null)
        {
            return "redirect:/";
        }

        List<WishListDTO> wishLists = wishListService.findAllByMember(loginInfo.getEmail());
        List<Long> merchandiseIds = wishLists.stream().map(w -> w.getMno()).collect(Collectors.toList());
        List<MerchandiseDTO> merchandises = merchandiseService.findAllByIds(merchandiseIds);

        model.addAttribute("merchandises", merchandises);
        model.addAttribute("loginInfo", loginInfo);
        return "wishlist";
    }

}
