package com.example.l2.repository;

import com.example.l2.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// класс для работы с БД, помогает осуществлять все запросы к БД
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByGenreId(Long id);
}
