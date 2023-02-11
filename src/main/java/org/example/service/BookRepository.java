package org.example.service;

import org.example.model.Book;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.List;

@EntityScan("org.example.model")
@Repository

public interface BookRepository extends CrudRepository<Book,Long> {
 Book findBookByBookId(Long bookId);
 List<Book> findBooksByName(String name);
}
