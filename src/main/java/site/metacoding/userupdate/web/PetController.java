package site.metacoding.userupdate.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.pet.Pet;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.service.PetService;

@RequiredArgsConstructor
@Controller
public class PetController {
    private final PetService petService;
    private final HttpSession session;

    @PostMapping("/s/user/{id}/pet")
    public String petInfo(@PathVariable Integer id, Pet pet) {
        User principal = (User) session.getAttribute("principal");

        pet.setUser(principal);
        petService.펫정보(pet, id);
        return "redirect:/s/user/" + id;
    }
}
