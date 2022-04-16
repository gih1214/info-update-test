package site.metacoding.userupdate.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.service.PetService;

@RequiredArgsConstructor
@RestController
public class PetApiController {

    private final PetService petService;
    private final HttpSession session;

    // 반려동물 정보 수정하기
    @PutMapping("/s/api/user/{id}/pet-update-form")
    public String petUpdate() {
        return null;
    }

    // 반려동물 정보 삭제하기
    @DeleteMapping("/s/api/pet/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {

        // 세션의 id와 comment의 userId와 비교
        User principal = (User) session.getAttribute("principal");

        petService.펫삭제(id, principal);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
