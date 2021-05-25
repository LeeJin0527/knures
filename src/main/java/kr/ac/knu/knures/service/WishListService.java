package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.ReplyDTO;
import kr.ac.knu.knures.dto.WishListDTO;
import kr.ac.knu.knures.entity.MemberEntity;
import kr.ac.knu.knures.entity.MerchandiseEntity;
import kr.ac.knu.knures.entity.ReplyEntity;
import kr.ac.knu.knures.entity.WishListEntity;

import java.util.List;
import java.util.Optional;

public interface WishListService {
    List<WishListDTO> findAllByMember(String email);
    WishListDTO findByMemberAndMerchandise(String email, Long mno);
    void register(WishListDTO dto);
    void delete(String email, Long mno);

    default WishListEntity dtoToEntity(WishListDTO dto) {
        MerchandiseEntity merchandiseEntity = MerchandiseEntity.builder().mno(dto.getMno()).build();
        MemberEntity memberEntity = MemberEntity.builder().email(dto.getEmail()).build();
        WishListEntity entity = WishListEntity.builder()
                .wno(dto.getWno())
                .member(memberEntity)
                .merchandise(merchandiseEntity)
                .build();

        return entity;
    }

    default WishListDTO entityToDto(WishListEntity entity, MemberEntity memberEntity, MerchandiseEntity merchandiseEntity){
        WishListDTO dto =WishListDTO.builder()
                .wno(entity.getWno())
                .email(memberEntity.getEmail())
                .mno(merchandiseEntity.getMno())
                .build();

        return dto;

    }
}
