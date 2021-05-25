package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.MapDTO;
import kr.ac.knu.knures.dto.MerchandiseDTO;
import kr.ac.knu.knures.entity.MerchandiseEntity;
import kr.ac.knu.knures.repository.MapRepository;
import kr.ac.knu.knures.repository.MerchandiseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService{
    private final MapRepository repository;

    @Override
    public void register(MapDTO dto) {
        repository.save(dtoToEntity(dto)); //dto -> dao -> repository -> db
    }

    @Override
    public void delete(MapDTO dto) {
        repository.delete(dtoToEntity(dto));
    }

    @Override
    public List<MapDTO> getListAll() {
        return repository.findAll().stream().map(entity -> entityToDto(entity))
                .collect(Collectors.toList());
    }


}
