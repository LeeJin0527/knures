package kr.ac.knu.knures.service;

import kr.ac.knu.knures.constant.LocationCategory;
import kr.ac.knu.knures.dto.CommunityBoardDTO;
import kr.ac.knu.knures.dto.MerchandiseDTO;
import kr.ac.knu.knures.entity.MerchandiseEntity;
import kr.ac.knu.knures.repository.CommunityBoardRepository;
import kr.ac.knu.knures.repository.MerchandiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MerchandiseServiceImpl implements MerchandiseService{
    private final MerchandiseRepository repository;

    @Override
    public List<MerchandiseDTO> findAllByIds(List<Long> ids) {
        return repository.findAllById(ids).stream()
                .map(entity -> entityToDto(entity, entity.getWriter()))
                .collect(Collectors.toList());
    }

    @Override
    public MerchandiseDTO getOne(Long mno) {
        Optional<MerchandiseEntity> res = repository.findById(mno);
        if (res.isPresent()) {
            MerchandiseEntity entity = res.get();
            return entityToDto(entity, entity.getWriter());
        }
        return null;
    }

    @Override
    public void register(MerchandiseDTO dto) {
        repository.save(dtoToEntity(dto)); //dto -> dao -> repository -> db
    }

    @Override
    public void delete(MerchandiseDTO dto) {
        repository.delete(dtoToEntity(dto));
    }

    @Override
    public List<MerchandiseDTO> getListAll() {
        return repository.findAll().stream().map(entity -> entityToDto(entity, entity.getWriter()))
                .collect(Collectors.toList());
    }

    @Override
    public List<MerchandiseDTO> findAllByLCategory(LocationCategory locationCategory) {
        return repository.findAllByLcategory(locationCategory).stream().map(entity -> entityToDto(entity, entity.getWriter()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllByLCategoryToName(LocationCategory locationCategory) {
        return repository.findAllByLcategory(locationCategory).stream().map(entity -> entityToName(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getListNameAll() {
        return repository.findAll().stream().map(entity -> entityToName(entity))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getListCategoryAll() {
        return repository.findAll().stream().map(entity -> entityToCategory(entity))
                .collect(Collectors.toList());
    }


}
