package site.metacoding.userupdate.web;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.service.UserService;
import site.metacoding.userupdate.web.api.dto.user.ImgUploadDto;
import site.metacoding.userupdate.web.api.dto.user.JoinDto;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    // 테스트 완료
    // 프로필 사진 수정 업로드
    @PostMapping("/s/user/{id}/img-upload")
    public String imgUpload(@PathVariable Integer id, ImgUploadDto imgUploadDto) {
        userService.이미지수정(id, imgUploadDto); // DB에는 이미지 경로를 저장

        return "redirect:/s/user/{id}";
    }

    // 테스트 완료
    // 회원정보수정폼
    @GetMapping("/s/user/{id}")
    public String userInfo(@PathVariable Integer id, Model model) {
        User userEntity = userService.회원정보(id);
        model.addAttribute("user", userEntity);
        return "user/updateForm";
    }

    // 테스트 완료
    // 회원가입폼
    @GetMapping("/join-form")
    public String joinForm() {
        return "/user/joinForm";
    }

    // 리팩토링 완료
    // 테스트 완료
    // 회원가입
    @PostMapping("/join")
    public String join(JoinDto joinDto) {
        userService.회원가입(joinDto);
        return "redirect:/login-form";
    }

    // 테스트 완료
    // 로그인폼
    @GetMapping("/login-form")
    public String loginForm() {
        return "/user/loginForm";
    }

}
