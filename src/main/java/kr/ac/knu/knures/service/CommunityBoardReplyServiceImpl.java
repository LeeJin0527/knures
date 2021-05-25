package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.CommunityBoardReplyDTO;
import kr.ac.knu.knures.dto.ReplyDTO;
import kr.ac.knu.knures.entity.ReplyEntity;
import kr.ac.knu.knures.repository.CommunityBoardReplyRepository;
import kr.ac.knu.knures.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityBoardReplyServiceImpl implements CommunityBoardReplyService {
    private final CommunityBoardReplyRepository repository;

    @Override
    public void register(CommunityBoardReplyDTO dto) {
        repository.save(dtoToEntity(dto));
    }

    @Transactional
    @Override
    public void delete(Long bno) {
        repository.deleteByBno(bno);
    }

    @Override
    public List<CommunityBoardReplyDTO> getListAllByGno(Long gno) {
        return repository.findAllByBoardEntity_Gno(gno).stream().map(entity -> entityToDto(entity, entity.getMemberEntity(), entity.getBoardEntity()))
                .collect(Collectors.toList());
    }
}