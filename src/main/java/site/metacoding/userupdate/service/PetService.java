package site.metacoding.userupdate.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.pet.Pet;
import site.metacoding.userupdate.domain.pet.PetRepository;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.domain.user.UserRepository;
import site.metacoding.userupdate.web.api.dto.pet.UpdateDto;

@RequiredArgsConstructor
@Service
public class PetService {
    private final PetRepository petRepository;
    private final UserRepository userRepository;

    // 테스트 완료
    // 펫 수정
    @Transactional
    public void 펫수정(Integer id, UpdateDto updateDto) {

        Optional<Pet> petOp = petRepository.findById(id);

        if (petOp.isPresent()) {
            // 영속화된 오브젝트 수정
            Pet petEntity = petOp.get();
            petEntity.setPetName(updateDto.getPetName());
            petEntity.setPetGender(updateDto.getPetGender());
            petEntity.setPetSpices(updateDto.getPetSpices());
            petEntity.setPetAge(updateDto.getPetAge());
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다.");
        }
    }

    // 테스트 완료
    // 펫 삭제
    @Transactional
    public void 펫삭제(Integer id, User principal) {
        // 권한체크할 때 사용하기
        // Optional<Pet> petOp = petRepository.findById(id);
        // if (petOp.isPresent()) {
        // Pet petEntity = petOp.get();
        // if (principal.getId() != petEntity.getUser().getId()) {
        // throw new RuntimeException("권한이 없습니다");
        // }
        // } else {
        // throw new RuntimeException("해당 댓글이 없습니다");
        // }

        petRepository.deleteById(id);
    }

    // 테스트 완료
    public Pet 펫정보보기(Integer userId) {
        Pet petEntity = petRepository.pUpdate(userId);
        return petEntity;
    }

    // 테스트완료
    @Transactional
    public void 펫정보추가(Integer userId, Pet pet) {

        Optional<User> userOp = userRepository.findById(userId);

        if (userOp.isPresent()) {
            User userEntity = userOp.get();
            pet.setUser(userEntity);
        } else {
            throw new RuntimeException("펫정보를 입력할 수 없습니다");
        }

        petRepository.save(pet);
    }
}
