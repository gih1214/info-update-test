package site.metacoding.userupdate.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.userupdate.domain.user.User;
import site.metacoding.userupdate.domain.user.UserRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    // 회원가입
    public void 회원가입(User user) {
        userRepository.save(user);
    }
}
