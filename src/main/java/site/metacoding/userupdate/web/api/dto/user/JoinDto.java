package site.metacoding.userupdate.web.api.dto.user;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.userupdate.domain.user.User;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinDto {
    // 유저정보
    private String userId;
    private String userName;
    private String password;
    private String phoneNum;
    private MultipartFile file;

    public User toEntity(String userImgurl) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhoneNum(phoneNum);
        user.setUserImgurl(userImgurl);
        return user;
    }
}
