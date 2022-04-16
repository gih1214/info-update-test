package site.metacoding.userupdate.web.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.service.PetService;

@RequiredArgsConstructor
@RestController
public class PetApiController {

    private final PetService petService;

    // 반려동물 정보 수정하기
    @PutMapping("/s/api/user/{id}/pet-update-form")
    public String petUpdate() {
        return null;
    }

    // 반려동물 정보 삭제하기
    @DeleteMapping("/s/api/user/{id}/pet-delete-form")
    public String petDelete() {
        return null;
    }
}
