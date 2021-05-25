package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.MailDTO;
import kr.ac.knu.knures.entity.MailEntity;

import java.util.Optional;

public interface MailService {
    void register(MailDTO dto);
    void delete(MailDTO dto);
    void setNum(String address, String num);
    void mailSend(MailDTO mailDto);
    String getAuthCode(int n);
    boolean checkNum(String email, String num);

    default MailEntity dtoToEntity(MailDTO dto) {
        MailEntity entity = MailEntity.builder()
                .address(dto.getAddress())
                .num(dto.getNum())
                .build();

        return entity;
    }

    default MailDTO entityToDto(MailEntity entity){
        MailDTO dto = MailDTO.builder()
                .address(entity.getAddress())
                .num(entity.getNum())
                .build();
        return dto;
    }



}
