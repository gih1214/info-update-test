package site.metacoding.userupdate.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.pet.Pet;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.service.PetService;
import site.metacoding.userupdate.service.UserService;

@RequiredArgsConstructor
@Controller
public class PetController {
    private final UserService userService;
    private final PetService petService;
    private final HttpSession session;

    // 테스트 완료
    // 펫정보 수정하기 폼
    @GetMapping("/s/user/{userId}/pet-update-form")
    public String updateForm(@PathVariable Integer userId, Model model) {
        Pet petEntity = petService.펫정보보기(userId);
        model.addAttribute("pet", petEntity);
        // syso은 User에서 toString을 직접 설정했을 때만 사용할 것. 아니면 오류터짐
        // System.out.println(petEntity);
        return "/pet/updateForm";
    }

    // 테스트 완료
    // 펫정보 추가하기 폼
    @GetMapping("/s/user/{userId}/pet-form")
    public String petInfoForm(@PathVariable Integer userId, Model model) {
        User userEntity = userService.펫정보추가폼(userId);
        model.addAttribute("user", userEntity);
        return "/pet/petInfoForm";
    }

    // 테스트 완료
    // 펫정보 추가하기
    @PostMapping("/s/user/{userId}/pet")
    public String petInfo(@PathVariable Integer userId, Pet pet) {
        User principal = (User) session.getAttribute("principal");

        pet.setUser(principal);
        petService.펫정보추가(userId, pet);

        return "redirect:/s/user/" + userId + "/pet-update-form";
    }
}
