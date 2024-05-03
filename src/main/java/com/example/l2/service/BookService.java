package com.example.l2.service;

import lombok.AllArgsConstructor;
import com.example.l2.dto.BookDTO;
import com.example.l2.entity.Book;
import com.example.l2.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// все описанные здесь методы работают с БД
@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final GenreService genreService;

    // добавление книги в БД
    public Book create(BookDTO dto) {
        return bookRepository.save(Book.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .pages(dto.getPages())
                .genre(genreService.readById(dto.getGenreId()))
                .build());
    }

    // просмотр всех книг из БД
    public List<Book> readAll() {
        return bookRepository.findAll();
    }

    // просмотр книги по id
    public Book read(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        return bookOptional.orElse(null);
    }

    // обновление данных по id в БД
    public boolean update(Book book, Long id) {
        Optional<Book> existingBookOptional = bookRepository.findById(id);
        if (existingBookOptional.isPresent()) {
            book.setId(id);
            bookRepository.save(book); // Сохранение обновленной информации о книге
            return true;
        }
        return false;
    }

    // удаление книги по id в БД
    public boolean delete(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Book> readByGenreId(Long id) {
        return bookRepository.findByGenreId(id);
    }
}
