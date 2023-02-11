package org.example.service;

import org.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class BookService {
    @Autowired
    private final BookRepository repository;
    private List<Book> books = new ArrayList<>();

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    List<Book> getAllBooks() {

        repository.findAll().forEach(books::add);
        return books;
    }

    public ResponseEntity<Book> addBook(Book book) {
        books = getAllBooks();
        Book savedBook = repository.save(book);

        if (repository.save(book).getClass() == Book.class) {
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    Book searchById(Long id) {
        return repository.findBookByBookId(id);
    }

    List<Book> getByName(String name) {
        return repository.findBooksByName(name);
    }
}
