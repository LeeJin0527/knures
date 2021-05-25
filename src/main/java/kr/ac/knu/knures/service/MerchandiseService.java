package kr.ac.knu.knures.service;

import kr.ac.knu.knures.constant.LocationCategory;
import kr.ac.knu.knures.dto.MerchandiseDTO;
import kr.ac.knu.knures.entity.MemberEntity;
import kr.ac.knu.knures.entity.MerchandiseEntity;

import java.util.List;

public interface MerchandiseService {
    List<MerchandiseDTO> getListAll();
    List<String> getListNameAll();
    List<String> getListCategoryAll();
    MerchandiseDTO getOne(Long mno);
    void register(MerchandiseDTO dto);
    void delete(MerchandiseDTO dto);
    List<MerchandiseDTO> findAllByIds(List<Long> ids);
    List<MerchandiseDTO> findAllByLCategory(LocationCategory locationCategory);
    List<String> findAllByLCategoryToName(LocationCategory locationCategory);

    //DAO 를 가져와서 보여줌
    default MerchandiseEntity dtoToEntity(MerchandiseDTO dto) {
        MemberEntity memberEntity = MemberEntity.builder().email(dto.getWriterEmail()).build();
        MerchandiseEntity entity = MerchandiseEntity.builder()
                .mno(dto.getMno())
                .content(dto.getContent())
                .title(dto.getTitle())
                .writer(memberEntity)
                .category(dto.getCategory())
                .lcategory(dto.getLcategory())
                .price(dto.getPrice())
                .state(dto.getState())
                .imgURL1(dto.getImgURL1())
                .imgURL2(dto.getImgURL2())
                .imgURL3(dto.getImgURL3())
                .build();

        return entity;
    }

    default MerchandiseDTO entityToDto(MerchandiseEntity entity, MemberEntity memberEntity){
        MerchandiseDTO dto = MerchandiseDTO.builder()
                .mno(entity.getMno())
                .content(entity.getContent())
                .title(entity.getTitle())
                .writer(memberEntity.getName())
                .writerEmail(memberEntity.getEmail())
                .category(entity.getCategory())
                .lcategory(entity.getLcategory())
                .regDate(entity.getRegDate())
                .price(entity.getPrice())
                .state(entity.getState())
                .imgURL1(entity.getImgURL1())
                .imgURL2(entity.getImgURL2())
                .imgURL3(entity.getImgURL3())
                .build();
        return dto;

    }

    default String entityToName(MerchandiseEntity entity){
        String dto = entity.getTitle();
        return dto;
    }

    default String entityToCategory(MerchandiseEntity entity){
        String dto = entity.getCategory();
        return dto;
    }
}
