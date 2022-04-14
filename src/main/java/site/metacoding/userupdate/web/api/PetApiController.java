package site.metacoding.userupdate.web.api;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.service.PetService;

@RequiredArgsConstructor
@RestController
public class PetApiController {

    private final PetService petService;

}
