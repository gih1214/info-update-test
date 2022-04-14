package site.metacoding.userupdate.web.api.dto.user;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.userupdate.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImgUploadDto {
    private MultipartFile file; // form 태그 name="file"

    public User toEntity(String userImgurl) {
        User user = new User();
        user.setUserImgurl(userImgurl);
        return user;
    }
}
