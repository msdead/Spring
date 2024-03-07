package ru.manerov.books.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.manerov.books.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
