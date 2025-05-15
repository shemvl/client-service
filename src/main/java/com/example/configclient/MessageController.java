package com.example.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Value("${custom.message:нет сообщения}")
    private String message;

    @Value("${server.port:8080}")
    private String defaultPort;

    @Autowired
    private ServletWebServerApplicationContext webServerAppCont;

    @GetMapping("/")
    public String readMessage() {
        int port = webServerAppCont.getWebServer().getPort();

        return "defaultPort: " + defaultPort + "; message: " + message + "; realPort: " + port;
    }
}
