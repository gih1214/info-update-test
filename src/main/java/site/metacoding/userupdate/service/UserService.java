package site.metacoding.userupdate.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.domain.user.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

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

    // 회원가입
    public void 회원가입(User user) {
        userRepository.save(user);
    }
}
