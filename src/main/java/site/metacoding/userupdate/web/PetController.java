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
import site.metacoding.userupdate.web.api.dto.pet.UpdateDto;

@RequiredArgsConstructor
@Controller
public class PetController {
    private final PetService petService;
    private final HttpSession session;

    // // 펫정보 폼
    // @GetMapping("/s/user/{id}/pet-form")
    // public String userInfo(@PathVariable Integer id, Model model, Pet pet) {
    // List<Pet> petEntity = petService.펫정보추가(id, pet);
    // model.addAttribute("pet", petEntity);
    // System.out.println(petEntity);
    // return "pet/updateForm";
    // }

    // 펫정보 폼
    @GetMapping("/s/user/{id}/pet-form")
    public String petInfo(@PathVariable Integer id, Model model) {
        Pet petEntity = petService.펫정보보기(id);
        model.addAttribute("pet", petEntity);
        System.out.println(petEntity);
        return "/pet/updateForm";
    }

    // 테스트 완료(DB에 들어감)
    // 펫정보 추가하기
    @PostMapping("/s/user/{id}/pet")
    public String petInfo(@PathVariable Integer id, Pet pet) {
        User principal = (User) session.getAttribute("principal");
        pet.setUser(principal);
        petService.펫정보추가(id, pet);
        return "redirect:/s/user/" + id;
    }
}
