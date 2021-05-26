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
    public String List(Model model) {


        LocationCategory ResidenceList[] = { LocationCategory.ONE_ROOM_FRONT,
                LocationCategory.ONE_ROOM_BACK,
                LocationCategory.DORMITORY_JAJU,
                LocationCategory.DORMITORY_CHANGJO,
                LocationCategory.DORMITORY_CHUNGWOON,
                LocationCategory.DORMITORY_NOAK,
                LocationCategory.DORMITORY_KUNMEYON,
                LocationCategory.DORMITORY_KYUNGAE};
        List<String> dtos = new ArrayList<>();

        for (LocationCategory residence : ResidenceList ) {
            dtos.addAll(merchandiseService.findAllByLCategoryToName(residence));
        }
        model.addAttribute("merchandises", dtos);


        return "map";
    }

}
