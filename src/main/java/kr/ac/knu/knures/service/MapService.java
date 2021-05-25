package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.MapDTO;
import kr.ac.knu.knures.dto.MemberDTO;
import kr.ac.knu.knures.entity.MapEntity;
import kr.ac.knu.knures.entity.MemberEntity;

import java.util.List;

public interface MapService {
    List<MapDTO> getListAll();
    void register(MapDTO dto);
    void delete(MapDTO dto);

    //DAO 를 가져와서 보여줌
    default MapEntity dtoToEntity(MapDTO dto) {
        MapEntity entity = MapEntity.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .XPoint(dto.getXPoint())
                .YPoint((dto.getYPoint()))
                .build();

        return entity;
    }

    default MapDTO entityToDto(MapEntity entity){
        MapDTO dto = MapDTO.builder()
                .name(entity.getName())
                .email(entity.getEmail())
                .XPoint(entity.getXPoint())
                .YPoint((entity.getYPoint()))
                .build();
        return dto;
    }


}