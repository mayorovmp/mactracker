package com.mactracker.service.impl;

import com.mactracker.entity.Session;
import com.mactracker.entity.User;
import com.mactracker.exception.EntityNotFoundException;
import com.mactracker.repository.SessionRepository;
import com.mactracker.repository.UserRepository;
import com.mactracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final SessionRepository sessionRepo;
    private final UserRepository userRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<User> findByToken(String token) {
        return sessionRepo.findByToken(token)
                .map(Session::getUser);
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
    }

    @Transactional(rollbackFor = Exception.class)
    public void register(String email, String pass) {
        if (userRepository.findByEmail(email).isPresent())
            throw new EntityNotFoundException("Пользователь уже существует");
        var userEntity = User.builder()
                .email(email)
                .password(pass)
                .build();
        userRepository.saveAndFlush(userEntity);
    }

    @Transactional(rollbackFor = Exception.class)
    public String login(String email, String pass) {
        var user = userRepository.findByEmailAndPass(email, pass)
                .orElseThrow(() -> new EntityNotFoundException("Пользователь не найден"));
        var session = Session.builder()
                .user(user)
                .token(UUID.randomUUID().toString())
                .created(ZonedDateTime.now())
                .build();
        sessionRepo.save(session);
        return session.getToken();
    }
}
