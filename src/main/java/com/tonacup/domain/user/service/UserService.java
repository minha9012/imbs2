package com.tonacup.domain.user.service;

import com.tonacup.domain.user.User;
import com.tonacup.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public long join(User user) {
        log.info("userId:{}", user.getId());
        log.info("userName:{}", user.getUsername());
        log.info("userEmail:{}", user.getEmail());
        //TODO:중복가입 체크
        userRepository.save(user);
        return user.getId();
    }

    public List<User> findUsers() {
        return userRepository.findByAll();
    }

    public Optional<User> findId(Long userId) {
        log.info("class:{}", getClass());
        log.info("userId:{}", userId);
        return userRepository.findById(userId);
    }

    public Optional<User> findEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
