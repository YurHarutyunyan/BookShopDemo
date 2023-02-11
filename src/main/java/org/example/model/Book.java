package org.example.model;

import javax.persistence.*;

@Table(name = "book")
@Entity
public class Book {
    String name;
    String genre;
    @ManyToOne
    Author author;
    @Id
    @SequenceGenerator(name = "book_id_seq", sequenceName = "seqName")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqName")
    Long bookId;

    public Book() {
    }

    public Book(String genre, String name, Author author, Long bookId) {
        this.genre=genre;
        this.author=author;
        this.bookId=bookId;
        this.name=name;
    }
    public Book(String genre, String name,Long bookId,Author author){
        this.author=author;
        this.name=name;
        this.bookId=bookId;
        this.genre=genre;
    }
}
