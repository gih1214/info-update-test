package site.metacoding.userupdate.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.pet.Pet;
import site.metacoding.userupdate.domain.pet.PetRepository;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.domain.user.UserRepository;

@RequiredArgsConstructor
@Service
public class PetService {
    private final PetRepository petRepository;
    private final UserRepository userRepository;

    public Pet 펫정보보기(Integer userId) {
        Pet petEntity = petRepository.pUpdate(userId);
        return petEntity;
    }

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
