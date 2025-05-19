package com.example.clientservice.controller;

import com.example.clientservice.model.Book;
import com.example.clientservice.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/books")
@AllArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<Book> getAllBooks() {
        return clientService.getAllBooks();
    }
}
