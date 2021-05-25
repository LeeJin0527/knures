package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.ReplyDTO;
import kr.ac.knu.knures.entity.MemberEntity;
import kr.ac.knu.knures.entity.MerchandiseEntity;
import kr.ac.knu.knures.entity.ReplyEntity;

import java.util.List;

public interface ReplyService {
    List<ReplyDTO> findAllByMerchandise(Long mno);
    ReplyDTO getOne(Long rno);
    void register(ReplyDTO dto);
    void delete(Long rno);
    //DAO 를 가져와서 보여줌
    default ReplyEntity dtoToEntity(ReplyDTO dto) {
        MerchandiseEntity merchandiseEntity = MerchandiseEntity.builder().mno(dto.getMno()).build();
        MemberEntity memberEntity = MemberEntity.builder().email(dto.getReplierEmail()).build();
        ReplyEntity entity = ReplyEntity.builder()
                .rno(dto.getRno())
                .text(dto.getText())
                .member(memberEntity)
                .merchandise(merchandiseEntity)
                .build();

        return entity;
    }

    default ReplyDTO entityToDto(ReplyEntity entity, MemberEntity memberEntity, MerchandiseEntity merchandiseEntity){
        ReplyDTO dto = ReplyDTO.builder()
                .rno(entity.getRno())
                .text(entity.getText())
                .replierEmail(memberEntity.getEmail())
                .replier(memberEntity.getName())
                .mno(merchandiseEntity.getMno())
                .build();

        return dto;

    }
}
