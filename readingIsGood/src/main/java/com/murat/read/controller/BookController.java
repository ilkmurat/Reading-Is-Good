package com.murat.read.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.murat.read.repository.BookRepositoryI;
import com.murat.read.model.Book;

@RestController
@RequestMapping("/read")
@CrossOrigin("*")
public class BookController {
	
    @Autowired
    BookRepositoryI bookRepo;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
    
    //----Create a book ----//
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        bookRepo.save(book);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
    
    @GetMapping(value ="/books/{bookId}")
    public ResponseEntity<Book> getBookByBookId(@PathVariable("bookId") String bookId) {
        return bookRepo.findById(bookId)
                .map(book -> ResponseEntity.ok().body(book))
                .orElse(ResponseEntity.notFound().build());
    }

}
