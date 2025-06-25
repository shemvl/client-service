package com.example.clientservice.connector;

import com.example.clientservice.model.Book;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
class Fallback implements BookServiceConnector {

    @Override
    public List<Book> getAllBooks() {
        return Collections.emptyList();
    }
}
