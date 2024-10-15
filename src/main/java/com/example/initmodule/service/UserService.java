package com.example.initmodule.service;

import com.example.initmodule.controller.request.UserJoinRequest;
import com.example.initmodule.domain.UserDetailsImpl;
import com.example.initmodule.domain.entity.UserAccount;
import com.example.initmodule.etc.response.error.CustomException;
import com.example.initmodule.etc.response.error.ExceptionCode;
import com.example.initmodule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void join(UserJoinRequest request) {
        String email = request.getEmail();
        String password = passwordEncoder.encode(request.getPassword());
        String username = request.getUsername();

        userRepository.findByEmail(email).ifPresent(user -> {
            throw new CustomException(ExceptionCode.USER_ALREADY_EXISTS, String.format("%s Already Existed", email));
        });
        userRepository.save(email, password, username);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 이메일로 사용자 조회
        UserAccount userAccount = userRepository.findByEmail(email).orElse(null);
        log.info("UserService 거쳐가유 ~");
        if (userAccount == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new UserDetailsImpl(userAccount);
    }

}