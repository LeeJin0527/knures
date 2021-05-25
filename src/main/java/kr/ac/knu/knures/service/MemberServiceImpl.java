package kr.ac.knu.knures.service;

import kr.ac.knu.knures.dto.CommunityBoardDTO;
import kr.ac.knu.knures.dto.MemberDTO;
import kr.ac.knu.knures.dto.MerchandiseDTO;
import kr.ac.knu.knures.entity.MemberEntity;
import kr.ac.knu.knures.repository.CommunityBoardRepository;
import kr.ac.knu.knures.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository repository;

    @Override
    public List<MemberDTO> getListAll() {
        return repository.findAll().stream().map(entity -> entityToDto(entity))
                .collect(Collectors.toList());
    }

    @Override
    public boolean checkLoginSuccess(String email, String password) {
        Optional<MemberEntity> res = repository.findById(email);
        if (res.isPresent()){
            MemberEntity entity = res.get();
            if (entity.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void register(MemberDTO dto) {
        repository.save(dtoToEntity(dto)); //dto -> dao -> repository -> db
    }

    @Override
    public void delete(MemberDTO dto) {
        repository.delete(dtoToEntity(dto));
    }

}
