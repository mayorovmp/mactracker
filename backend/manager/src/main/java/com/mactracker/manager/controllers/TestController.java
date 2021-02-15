package com.mactracker.manager.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "test")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/test")
public class TestController {

    @ApiOperation(tags = "approval", value = "Получить лист согласования", notes = "Получить лист согласования")
    @GetMapping(value = "")
    public ResponseEntity<String> getLastLoginEmployee() {
        var s = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok("Ok");
    }

    @GetMapping(value = "1")
    public ResponseEntity<String> getLastLoginEmployee1() {

        return ResponseEntity.ok("Ok");
    }
}
