package site.metacoding.userupdate.web.api;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.service.PetService;
import site.metacoding.userupdate.web.api.dto.pet.UpdateDto;

@RequiredArgsConstructor
@RestController
public class PetApiController {

    private final PetService petService;
    private final HttpSession session;

    // 테스트 완료
    // 반려동물 정보 수정하기
    @PutMapping("/s/api/pet/{id}")
    public ResponseEntity<?> petUpdate(@PathVariable Integer id, @RequestBody UpdateDto updateDto) {
        petService.펫수정(id, updateDto);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    // 테스트 완료
    // 반려동물 정보 삭제하기
    @DeleteMapping("/s/api/pet/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {

        // 세션의 id와 comment의 userId와 비교
        User principal = (User) session.getAttribute("principal");

        petService.펫삭제(id, principal);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
