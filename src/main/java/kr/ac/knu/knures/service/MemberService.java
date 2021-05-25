package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.MemberDTO;
import kr.ac.knu.knures.entity.MemberEntity;

import java.util.List;

public interface MemberService {
    List<MemberDTO> getListAll();
    boolean checkLoginSuccess(String email, String password);
    void register(MemberDTO dto);
    void delete(MemberDTO dto);

    //DAO 를 가져와서 보여줌
    default MemberEntity dtoToEntity(MemberDTO dto) {
        MemberEntity entity = MemberEntity.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .name(dto.getName())
                .build();

        return entity;
    }

    default MemberDTO entityToDto(MemberEntity entity){
        MemberDTO dto = MemberDTO.builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .name(entity.getName())
                .build();
        return dto;
    }


}