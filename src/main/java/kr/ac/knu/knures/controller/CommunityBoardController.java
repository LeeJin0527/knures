package kr.ac.knu.knures.controller;

import kr.ac.knu.knures.dto.CommunityBoardDTO;
import kr.ac.knu.knures.dto.CommunityBoardReplyDTO;
import kr.ac.knu.knures.dto.PageRequestDTO;
import kr.ac.knu.knures.dto.PageResultDTO;
import kr.ac.knu.knures.entity.CommunityBoardEntity;
import kr.ac.knu.knures.service.CommunityBoardReplyService;
import kr.ac.knu.knures.service.CommunityBoardService;
import kr.ac.knu.knures.session.LoginInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/Community")
public class CommunityBoardController {
    private final CommunityBoardService service;
    private final CommunityBoardReplyService replyService;

    @Resource
    private LoginInfo loginInfo;

    @GetMapping("/")
    public String index(){
        return "redirect:/Community/list";
    }

    @GetMapping("/list")
    public String list(PageRequestDTO pageRequestDTO, Model model){
        PageResultDTO<CommunityBoardDTO, CommunityBoardEntity> result = service.getList(pageRequestDTO);
        System.out.println(result);
        model.addAttribute("result", result);
        model.addAttribute("pageRequestDTO", pageRequestDTO);
        model.addAttribute("loginInfo", loginInfo);
        return "list";
    }

    @GetMapping("/detail")
    public String detail(Long gno, Model model) {
        CommunityBoardDTO dto = service.getOne(gno);
        List<CommunityBoardReplyDTO> replies = replyService.getListAllByGno(gno);

        model.addAttribute("board", dto);
        model.addAttribute("replies", replies);
        model.addAttribute("loginInfo", loginInfo);

        return "detail";
    }

    @GetMapping("/register")
    public String register() { return "/register"; }


    @PostMapping("/register")
    public String registerPost(CommunityBoardDTO dto, RedirectAttributes redirectAttributes){

        //새로 추가된 엔티티의 번호
        dto.setWriterEmail(loginInfo.getEmail());
        Long gno = service.register(dto);

        redirectAttributes.addFlashAttribute("msg", gno);

        return "redirect:/Community/list";
    }


}
