package site.metacoding.userupdate.web.api.dto.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.userupdate.domain.pet.Pet;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PetResponseDto {
    private Pet pet;
    private boolean auth;
}
