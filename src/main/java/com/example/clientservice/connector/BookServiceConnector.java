package com.example.clientservice.connector;


import com.example.clientservice.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Collections;

@FeignClient(name = "BOOK-SERVICE", fallbackFactory = BookServiceConnectorFallbackFactory.class)
public interface BookServiceConnector {
    @GetMapping("/api/books")
    List<Book> getAllBooks();
}

@Component
class BookServiceConnectorFallbackFactory implements FallbackFactory<FallbackWithFactory> {
    @Override
    public FallbackWithFactory create(Throwable cause) {
        return new FallbackWithFactory(cause.getMessage());
    }
}
@Slf4j
record FallbackWithFactory(String reason) implements BookServiceConnector {
    @Override
    public List<Book> getAllBooks() {
        log.warn("FallbackFactory сработал, причина: {}", reason);
        Book info = new Book();
        info.setId(String.valueOf(-1L));
        info.setTitle("⚠️ FallbackFactory: не удалось связаться с book-service (" + reason + ")");
        return List.of(info);
    }
}