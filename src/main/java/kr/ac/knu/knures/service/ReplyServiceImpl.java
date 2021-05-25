package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.ReplyDTO;
import kr.ac.knu.knures.entity.MerchandiseEntity;
import kr.ac.knu.knures.entity.ReplyEntity;
import kr.ac.knu.knures.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
    private final ReplyRepository repository;

    @Override
    public ReplyDTO getOne(Long rno) {
        Optional<ReplyEntity> res = repository.findById(rno);
        if (res.isPresent()) {
            ReplyEntity entity = res.get();
            return entityToDto(entity, entity.getMember(), entity.getMerchandise());
        }
        return null;
    }

    @Override
    public void register(ReplyDTO dto) {
        repository.save(dtoToEntity(dto));
    }

    @Override
    public void delete(Long rno) {
        repository.deleteById(rno);
    }

    @Override
    public List<ReplyDTO> findAllByMerchandise(Long mno) {
        MerchandiseEntity merchandiseEntity = MerchandiseEntity.builder().mno(mno).build();
        return repository.findAllByMerchandise(merchandiseEntity).stream()
                .map(entity -> entityToDto(entity, entity.getMember(), entity.getMerchandise()))
                .collect(Collectors.toList());
    }
}