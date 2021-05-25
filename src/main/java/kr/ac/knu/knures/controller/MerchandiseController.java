package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.constant.LocationCategory;
import kr.ac.knu.knures.dto.CommunityBoardReplyDTO;
import kr.ac.knu.knures.dto.MerchandiseDTO;
import kr.ac.knu.knures.dto.ReplyDTO;
import kr.ac.knu.knures.dto.WishListDTO;
import kr.ac.knu.knures.service.MerchandiseService;
import kr.ac.knu.knures.service.ReplyService;
import kr.ac.knu.knures.service.WishListService;
import kr.ac.knu.knures.session.LoginInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/merchandise")
public class MerchandiseController {
    private final MerchandiseService service;
    private final WishListService wishListService;
    private final ReplyService replyService;

    @Resource
    private LoginInfo loginInfo;

    // 물품 등록
    @GetMapping("/register")
    public String register(Model model) {
        String loginEmail = loginInfo.getEmail();
        if (loginEmail == null) {
            return "redirect:/merchandise/list";
        }

        model.addAttribute("loginInfo", loginInfo);
        return "register_merchandise";
    }

    @PostMapping("/register")
    public String doRegister(MerchandiseDTO dto) {
        String loginEmail = loginInfo.getEmail();
        dto.setWriterEmail(loginEmail);

        System.out.println(dto);

        service.register(dto);
        return "redirect:/merchandise/list";
    }

    @GetMapping("/modify")
    public String modify(Long mno, Model model) {
        MerchandiseDTO dto = service.getOne(mno);
        model.addAttribute("merchandise", dto);
        model.addAttribute("loginInfo", loginInfo);
        return "modify_merchandise";
    }

   @GetMapping("/delete")
   public String delete(Long mno) {
       MerchandiseDTO dto = service.getOne(mno);
       service.delete(dto);
       return "redirect:/merchandise/list";
   }

    @GetMapping("/list")
    public String list(Model model) {
        List<MerchandiseDTO> dtos = service.getListAll();

        List<WishListDTO> wishListDTOS;
        if (loginInfo != null && loginInfo.getEmail() != null)
        {
            wishListDTOS = wishListService.findAllByMember(loginInfo.getEmail());

            dtos = dtos.stream().map(m -> {
                Optional<WishListDTO> res = wishListDTOS.stream()
                        .filter(w -> w.getMno().equals(m.getMno()))
                        .findFirst();

                m.setWish(res.isPresent());
                return m;
            }).collect(Collectors.toList());
        }

        model.addAttribute("merchandises", dtos);
        model.addAttribute("loginInfo", loginInfo);

        return "list_merchandise";
    }

    @GetMapping("/oneroom_list")
    public String oneRoomList(Model model) {
        LocationCategory oneRoomList[] = { LocationCategory.ONE_ROOM_FRONT, LocationCategory.ONE_ROOM_BACK };
        List<MerchandiseDTO> dtos = new ArrayList<>();
        for (LocationCategory oneRoom : oneRoomList) {
            dtos.addAll(service.findAllByLCategory(oneRoom));
        }

        List<WishListDTO> wishListDTOS;
        if (loginInfo != null && loginInfo.getEmail() != null)
        {
            wishListDTOS = wishListService.findAllByMember(loginInfo.getEmail());

            dtos = dtos.stream().map(m -> {
                Optional<WishListDTO> res = wishListDTOS.stream()
                        .filter(w -> w.getMno().equals(m.getMno()))
                        .findFirst();

                m.setWish(res.isPresent());
                return m;
            }).collect(Collectors.toList());
        }

        model.addAttribute("merchandises", dtos);
        model.addAttribute("loginInfo", loginInfo);

        return "list_merchandise";
    }

    @GetMapping("/dormitory_list")
    public String dormitoryList(Model model) {
        LocationCategory dormitoryList[] = { LocationCategory.DORMITORY_JAJU, LocationCategory.DORMITORY_CHANGJO,
                LocationCategory.DORMITORY_CHUNGWOON, LocationCategory.DORMITORY_NOAK, LocationCategory.DORMITORY_KUNMEYON,LocationCategory.DORMITORY_KYUNGAE };
        List<MerchandiseDTO> dtos = new ArrayList<>();
        for (LocationCategory dormitory : dormitoryList ) {
            dtos.addAll(service.findAllByLCategory(dormitory));
        }

        List<WishListDTO> wishListDTOS;
        if (loginInfo != null && loginInfo.getEmail() != null)
        {
            wishListDTOS = wishListService.findAllByMember(loginInfo.getEmail());

            dtos = dtos.stream().map(m -> {
                Optional<WishListDTO> res = wishListDTOS.stream()
                        .filter(w -> w.getMno().equals(m.getMno()))
                        .findFirst();

                m.setWish(res.isPresent());
                return m;
            }).collect(Collectors.toList());
        }

        model.addAttribute("merchandises", dtos);
        model.addAttribute("loginInfo", loginInfo);

        return "list_merchandise";
    }

    @GetMapping("/detail")
    public String detail(Long mno, Model model) {

        MerchandiseDTO dto = service.getOne(mno);
        List<ReplyDTO> replies = replyService.findAllByMerchandise(mno);

        if (loginInfo != null && loginInfo.getEmail() != null) {
            WishListDTO wishListDTO = wishListService.findByMemberAndMerchandise(loginInfo.getEmail(), mno);

            dto.setWish(wishListDTO != null);
        }

        model.addAttribute("merchandise", dto);
        model.addAttribute("replies", replies);
        model.addAttribute("loginInfo", loginInfo);

        return "detail_merchandise";
    }

}
