package com.mactracker.manager.controllers;

import com.mactracker.dto.user.UserDto;
import com.mactracker.dto.user.UserLoginDto;
import com.mactracker.dto.user.UserRegisterDto;
import com.mactracker.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "auth")
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final ModelMapper mapper;
    private final UserService userService;

    @ApiOperation(value = "login", notes = "login notes")
    @PostMapping("/login")
    public ResponseEntity<String> getToken(@RequestBody UserLoginDto user) {
        String token = userService.login(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @ApiOperation(tags = "approval", value = "Получить лист согласования", notes = "Получить лист согласования")
    @PostMapping("/me")
    public ResponseEntity<UserDto> me(@RequestBody UserLoginDto user)  {
        var me = userService.login(user.getEmail(), user.getPassword());
        var dto = mapper.map(me, UserDto.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(tags = "approval", value = "Получить лист согласования", notes = "Получить лист согласования")
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDto user) {
        userService.register(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
