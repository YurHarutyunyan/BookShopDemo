package org.example.model;

import javax.persistence.*;
import org.example.model.Book;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    private int age;
    private String name;
    @Id
    @SequenceGenerator(name = "authorGenerator", sequenceName = "authors_authorid_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorGenerator")
    private Long authorId;
    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private List<Book> bookList = new ArrayList<>();
    public Author toEntity(AuthorDTO authorDTO){
        Author author = new Author();
        this.name=name;
        this.authorId=authorId;
        this.age=age;
        this.bookList=bookList;
    return author;
    }
    public Author() {
    }

    public Author(List<Book> bookList, String name, int age, Long authorId) {
        this.age = age;
        this.name = name;
        this.authorId = authorId;
        this.bookList = bookList;
    }

    public AuthorDTO toDto() {
        AuthorDTO dto = new AuthorDTO();
        dto.setAge(this.age);
        dto.setAuthorId(this.authorId);
        dto.setBooks(this.bookList);
        dto.setName(this.name);
        return dto;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
