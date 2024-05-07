package com.example.l2.controller;

import lombok.AllArgsConstructor;
import com.example.l2.dto.BookDTO;
import com.example.l2.entity.Book;
import com.example.l2.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// все описанные здесь методы обращаются к сервису
@RestController
@AllArgsConstructor
public class  BookController {

    private final BookService bookService;

    /**
     Метод возвращает ResponseEntity<?>.
     ResponseEntity — специальный класс для возврата ответов.
     С помощью него мы сможем в дальнейшем вернуть клиенту HTTP статус код.
     */
    // метод создания книги
    @PostMapping(value = "/books")
    public ResponseEntity<Book> create(@RequestBody BookDTO dto) {
        return new ResponseEntity<>(bookService.create(dto), HttpStatus.CREATED);
    }

    // метод вывода всех книг
    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> readAll() {
        final List<Book> books = bookService.readAll();

        return books != null &&  !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // вывод книги по id
    @GetMapping(value = "/books/{id}")
    public ResponseEntity<Book> read(@PathVariable(name = "id") int id) {
        final Book book = bookService.read(Long.valueOf(id));

        return book != null
                ? new ResponseEntity<>(book, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // обновление данных по id
    @PutMapping(value = "/books/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Book book) {
        final boolean updated = bookService.update(book, Long.valueOf(id));
        if (book != null) {
            return updated
                    ? new ResponseEntity<>(HttpStatus.OK)
                    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // удаление книги по id
    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final boolean deleted = bookService.delete(Long.valueOf(id));
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books/genres/{id}")
    public ResponseEntity<List<Book>> readByGenreId(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.readByGenreId(id), HttpStatus.OK);
    }
}
