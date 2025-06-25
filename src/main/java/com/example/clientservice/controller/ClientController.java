package com.example.clientservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClientController {

    @ResponseBody
    @GetMapping("/api/client/test")
    public ResponseEntity<String> getString() {
        return ResponseEntity.ok("Hello ");
    }
}