package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.WishListDTO;
import kr.ac.knu.knures.entity.*;
import kr.ac.knu.knures.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListServiceImpl implements WishListService{
    private final WishListRepository repository;

    @Override
    public void delete(String email, Long mno) {
        WishListDTO dto = findByMemberAndMerchandise(email, mno);

        if (dto != null) {
            repository.delete(dtoToEntity(dto));
        }
    }

    @Override
    public void register(WishListDTO dto) {
        repository.save(dtoToEntity(dto));
    }

    @Override
    public List<WishListDTO> findAllByMember(String email) {
        MemberEntity memberEntity = MemberEntity.builder().email(email).build();

        return repository.findAllByMember(memberEntity).stream().map(entity ->
            entityToDto(entity, entity.getMember(), entity.getMerchandise())
        ).collect(Collectors.toList());
    }

    @Override
    public WishListDTO findByMemberAndMerchandise(String email, Long mno) {
        MemberEntity member = MemberEntity.builder().email(email).build();
        MerchandiseEntity merchandise = MerchandiseEntity.builder().mno(mno).build();
        Optional<WishListEntity> res = repository.findByMemberAndMerchandise(member, merchandise);
        if (res.isPresent()) {
            WishListEntity entity = res.get();
            return entityToDto(entity, entity.getMember(), entity.getMerchandise());
        }
        return null;
        //return Optional.empty();
    }


}
