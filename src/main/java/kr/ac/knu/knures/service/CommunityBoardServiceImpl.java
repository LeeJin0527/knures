package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.CommunityBoardDTO;
import kr.ac.knu.knures.dto.PageRequestDTO;
import kr.ac.knu.knures.dto.PageResultDTO;
import kr.ac.knu.knures.entity.CommunityBoardEntity;
import kr.ac.knu.knures.entity.CommunityBoardReplyEntity;
import kr.ac.knu.knures.entity.MemberEntity;
import kr.ac.knu.knures.repository.CommunityBoardReplyRepository;
import kr.ac.knu.knures.repository.CommunityBoardRepository;
import kr.ac.knu.knures.session.LoginInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;


import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CommunityBoardServiceImpl implements CommunityBoardService {
    //repository
    private final CommunityBoardRepository repository;

    @Override
    public CommunityBoardDTO getOne(Long gno) {
        Optional<CommunityBoardEntity> res = repository.findById(gno);
        if (res.isPresent()) {
            CommunityBoardEntity entity = res.get();
            List<CommunityBoardReplyEntity> replies = replyRepository.findAllByBoardEntity_Gno(entity.getGno());
            MemberEntity memberEntity = entity.getWriter();
            return entityToDto(entity, memberEntity, (long)replies.size());
        }
        return null;
    }

    private final CommunityBoardReplyRepository replyRepository;

    @Override
    public Long register(CommunityBoardDTO dto){
        CommunityBoardEntity entity = dtoToEntity((dto));

        repository.save(entity);
        return entity.getGno();
    }

    @Override
    public PageResultDTO<CommunityBoardDTO, CommunityBoardEntity> getList(PageRequestDTO requestDTO){
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());
        Page<CommunityBoardEntity> result = repository.findAll((org.springframework.data.domain.Pageable) pageable);

        Function<CommunityBoardEntity, CommunityBoardDTO> fn = (entity -> {
            List<CommunityBoardReplyEntity> replies = replyRepository.findAllByBoardEntity_Gno(entity.getGno());
            MemberEntity memberEntity = entity.getWriter();
            return entityToDto(entity, memberEntity, (long)replies.size());
        });

        return new PageResultDTO<>(result, fn);
    }
}
