package site.metacoding.userupdate.web.api.dto.pet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InsertDto {
    private String petName;
    private String petGender;
    private String petSpices;
    private String petAge;
    private Integer userId;
}
