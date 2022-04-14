package site.metacoding.userupdate.web.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.service.UserService;
import site.metacoding.userupdate.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@RestController
public class UserApiController {
    private final UserService userService;

    // 테스트 완료
    // 회원정보 수정
    @PutMapping("/s/api/user/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UpdateDto updateDto) {
        userService.회원수정(id, updateDto);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
