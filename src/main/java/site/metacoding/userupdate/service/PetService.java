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

    @Transactional
    public Pet 펫정보(UpdateDto updateDto) {

        Pet petEntity = petRepository.pUpdate(updateDto.getUserId());

        return petEntity;
        // Optional<Pet> userOp = petRepository.pUpdate(userid);

        // if (userOp.isPresent()) {
        // User userEntity = userOp.get();
        // pet.setUser(userEntity);
        // } else {
        // throw new RuntimeException("펫정보를 입력할 수 없습니다");
        // }

        // Pet petEntity = petRepository.save(pet);
        // return petEntity;
        // }
    }
}
