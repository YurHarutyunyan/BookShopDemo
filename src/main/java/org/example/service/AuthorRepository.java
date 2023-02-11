package org.example.service;

import org.example.model.Author;
import org.example.model.AuthorDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author getAuthorByName(String name);


    Author findAuthorByAuthorId(Long authorId);

    List<AuthorDTO> findAuthorByName(@Param("name") String name);

}
