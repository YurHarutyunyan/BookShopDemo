package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class AuthorDTO {
    private String name;
    private Integer age;
    private Long AuthorId;
    private List<Book> books = new ArrayList<>();

    public Author toEntity() {
            Author entity = new Author();
            entity.setAge(this.age);
            entity.setAuthorId(this.AuthorId);
            entity.setName(this.name);
            entity.setBookList(this.books);
    return entity;
    }

    public AuthorDTO() {
    }
    public AuthorDTO(String name,Integer age,Long authorId){
        this.name=name;
        this.age=age;
        this.AuthorId=authorId;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Long authorId) {
        AuthorId = authorId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
