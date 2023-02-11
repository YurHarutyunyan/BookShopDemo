package org.example.service;

import org.example.model.Author;
import org.example.model.AuthorDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository repository;
    @Autowired
    ModelMapper mapper;

    public List<AuthorDTO> getAuthorByName(String name) {
        return repository.findAuthorByName(name);
    }

    public AuthorDTO getAuthorById(Long id) {
        return repository.findAuthorByAuthorId(id).toDto();
    }
    public Author saveAuthor(AuthorDTO authorDTO){
        return repository.save(authorDTO.toEntity());
    }
}
