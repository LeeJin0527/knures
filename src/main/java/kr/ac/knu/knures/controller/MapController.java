package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.constant.LocationCategory;
import kr.ac.knu.knures.dto.MemberDTO;
import kr.ac.knu.knures.dto.MerchandiseDTO;
import kr.ac.knu.knures.dto.WishListDTO;
import kr.ac.knu.knures.service.MemberService;
import kr.ac.knu.knures.service.MerchandiseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@Log4j2
@RequiredArgsConstructor
public class MapController {
    private final MemberService mapService;
    private final MerchandiseService merchandiseService;

    @GetMapping("/map")
    public String list(Model model) {
        List<String> dtos1 = new ArrayList<>();
        List<String> dtos2 = new ArrayList<>();
        List<String> dtos3 = new ArrayList<>();
        List<String> dtos4 = new ArrayList<>();
        List<String> dtos5 = new ArrayList<>();
        List<String> dtos6 = new ArrayList<>();
        List<String> dtos7 = new ArrayList<>();
        List<String> dtos8 = new ArrayList<>();

        dtos1.addAll(merchandiseService.findAllByLCategoryToName(LocationCategory.DORMITORY_CHANGJO));
        dtos2.addAll(merchandiseService.findAllByLCategoryToName(LocationCategory.DORMITORY_JAJU));
        dtos3.addAll(merchandiseService.findAllByLCategoryToName(LocationCategory.DORMITORY_KUNMEYON));
        dtos4.addAll(merchandiseService.findAllByLCategoryToName(LocationCategory.DORMITORY_KYUNGAE));
        dtos5.addAll(merchandiseService.findAllByLCategoryToName(LocationCategory.DORMITORY_NOAK));
        dtos6.addAll(merchandiseService.findAllByLCategoryToName(LocationCategory.DORMITORY_CHUNGWOON));

        dtos7.addAll(merchandiseService.findAllByLCategoryToName(LocationCategory.ONE_ROOM_FRONT));
        dtos8.addAll(merchandiseService.findAllByLCategoryToName(LocationCategory.ONE_ROOM_BACK));


        model.addAttribute("merchandises1", dtos1);
        model.addAttribute("merchandises2", dtos2);
        model.addAttribute("merchandises3", dtos3);
        model.addAttribute("merchandises4", dtos4);
        model.addAttribute("merchandises5", dtos5);
        model.addAttribute("merchandises6", dtos6);
        model.addAttribute("merchandises7", dtos7);
        model.addAttribute("merchandises8", dtos8);
        return "map";
    }

}
