package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.CommunityBoardDTO;
import kr.ac.knu.knures.dto.PageRequestDTO;
import kr.ac.knu.knures.dto.PageResultDTO;
import kr.ac.knu.knures.entity.CommunityBoardEntity;
import kr.ac.knu.knures.entity.MemberEntity;

import java.util.List;

public interface CommunityBoardService {
    //List<CommunityBoardDTO> getListAll();
    Long register(CommunityBoardDTO communityBoardDTO);
    CommunityBoardDTO getOne(Long gno);

    PageResultDTO<CommunityBoardDTO, CommunityBoardEntity> getList(PageRequestDTO requestDTO);
    //DAO 를 가져와서 보여줌
    default CommunityBoardEntity dtoToEntity(CommunityBoardDTO dto) {
        MemberEntity memberEntity = MemberEntity.builder().email(dto.getWriterEmail()).build();
        CommunityBoardEntity entity = CommunityBoardEntity.builder()
                .gno(dto.getGno())
                .content(dto.getContent())
                .title(dto.getTitle())
                .writer(memberEntity)
                .build();

        return entity;
    }

    default CommunityBoardDTO entityToDto(CommunityBoardEntity entity, MemberEntity memberEntity, Long replyCount) {
        CommunityBoardDTO dto = CommunityBoardDTO.builder()
                .gno(entity.getGno())
                .content(entity.getContent())
                .title(entity.getTitle())
                .regDate(entity.getRegDate())
                .writerName(memberEntity.getName())
                .writerEmail(memberEntity.getEmail())
                .replyCount(replyCount)
                .build();
        return dto;

    }

}
