package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.CommunityBoardReplyDTO;
import kr.ac.knu.knures.dto.ReplyDTO;
import kr.ac.knu.knures.entity.*;

import java.util.List;

public interface CommunityBoardReplyService {
    List<CommunityBoardReplyDTO> getListAllByGno(Long gno);

    void register(CommunityBoardReplyDTO dto);
    void delete(Long bno);

    //DAO 를 가져와서 보여줌
    default CommunityBoardReplyEntity dtoToEntity(CommunityBoardReplyDTO dto) {
        CommunityBoardEntity communityBoardEntity = CommunityBoardEntity.builder().gno(dto.getGno()).build();
        MemberEntity memberEntity = MemberEntity.builder().email(dto.getReplierEmail()).build();
        CommunityBoardReplyEntity entity = CommunityBoardReplyEntity.builder()
                .bno(dto.getBno())
                .text(dto.getText())
                .memberEntity(memberEntity)
                .boardEntity(communityBoardEntity)
                .build();

        return entity;
    }

    default CommunityBoardReplyDTO entityToDto(CommunityBoardReplyEntity entity, MemberEntity memberEntity, CommunityBoardEntity communityBoardEntity){
        CommunityBoardReplyDTO dto = CommunityBoardReplyDTO.builder()
                .bno(entity.getBno())
                .text(entity.getText())
                .replierEmail(memberEntity.getEmail())
                .replier(memberEntity.getName())
                .gno(communityBoardEntity.getGno())
                .build();

        return dto;

    }
}
