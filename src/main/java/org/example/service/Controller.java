package org.example.service;

import org.example.model.Author;
import org.example.model.AuthorDTO;
import org.example.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/BookShop")
public class Controller {
    BookService bookService;
    AuthorService authorService;

    Controller(BookService service, AuthorService servicea) {
        this.bookService = service;
        this.authorService = servicea;
    }

    @RequestMapping(value = "/showList")
    public List<Book> showList() {
        List<Book> books = new ArrayList<>();
        books = bookService.getAllBooks();
        return books;
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping(value = "/getBookById")
    Book getById(Long id) {
        return bookService.searchById(id);
    }

    @PostMapping(value = "/getBookByName/{name}")
    List<Book> getByName(@PathVariable String name) {
        return bookService.getByName(name);
    }

    @RequestMapping(value = "/searchAuthor/{name}", method = RequestMethod.GET)
    List<AuthorDTO> searchAuthor(@PathVariable String name) {
        return authorService.getAuthorByName(name);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/AuthorInfoById/{id}")
    public AuthorDTO authorInfoById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/saveAuthor")
    public Author saveAuthor(@RequestBody AuthorDTO authorDto) {
        return authorService.saveAuthor(authorDto);
    }
}
