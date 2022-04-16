package site.metacoding.userupdate.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.domain.user.UserRepository;
import site.metacoding.userupdate.web.api.dto.user.ImgUploadDto;
import site.metacoding.userupdate.web.api.dto.user.UpdateDto;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 테스트 완료
    // 펫정보 추가하기 폼
    // 머스태치에 user의 id가 필요해서 만들었음
    public User 펫정보추가폼(Integer id) {
        Optional<User> userOp = userRepository.findById(id);

        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            System.out.println("아이디를 찾을 수 없습니다.");
            return null;
        }
    }

    // 테스트 완료
    // 회원 이미지(프로필사진) 수정
    @Transactional
    public void 이미지수정(Integer id, ImgUploadDto imgUploadDto) {
        UUID uuid = UUID.randomUUID(); // 범용 고유 식별자
        String requestFileName = imgUploadDto.getFile().getOriginalFilename();
        // System.out.println("전송받은 파일명 : " + requestFileName);

        String userImgurl = uuid + "_" + requestFileName;
        // jar 파일로 구우면 안 돌아감
        Path filePath = Paths.get("src/main/resources/static/upload/" + userImgurl);
        // System.out.println(filePath);

        try {
            Files.write(filePath, imgUploadDto.getFile().getBytes()); // (파일 경로, 이미지(바이트)) - 어느 경로에 어떤 파일 쓸건지

            // DB에는 이미지 경로를 저장
            Optional<User> userOp = userRepository.findById(id);
            if (userOp.isPresent()) {
                // 영속화된 오브젝트 수정
                User userEntity = userOp.get();
                userEntity.setUserImgurl(userImgurl);
            } else {
                throw new RuntimeException("아이디를 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 테스트 완료
    // 회원정보 수정
    @Transactional
    public void 회원수정(Integer id, UpdateDto updateDto) {
        // UPDATE user SET password = ?, name = ?, phoneNum = ? WHERE id = ?

        Optional<User> userOp = userRepository.findById(id);

        if (userOp.isPresent()) {
            // 영속화된 오브젝트 수정
            User userEntity = userOp.get();
            userEntity.setPassword(updateDto.getPassword());
            userEntity.setUserName(updateDto.getUserName());
            userEntity.setPhoneNum(updateDto.getPhoneNum());
        } else {
            throw new RuntimeException("아이디를 찾을 수 없습니다.");
        }
    }

    // 테스트 완료
    // 회원정보
    public User 회원정보(Integer id) {
        Optional<User> userOp = userRepository.findById(id);

        if (userOp.isPresent()) {
            return userOp.get();
        } else {
            System.out.println("아이디를 찾을 수 없습니다.");
            return null;
        }
    }

    // 테스트 완료
    // 회원가입
    @Transactional
    public void 회원가입(User user) {
        userRepository.save(user);
    }
}
