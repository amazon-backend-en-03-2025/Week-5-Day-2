package com.ironhack.helloforest.controller;

import com.ironhack.helloforest.dto.Greet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/greet")
public class GreetController {


    @GetMapping
    public String greet(@RequestHeader("name") String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/hello")
    public ResponseEntity<Greet> hello(){
        return ResponseEntity.accepted()
                .header("validationTime", "2 days")
                .body(new Greet("Hello, world!"));
    }

}
