package com.Library.Book_Management.Controller;

import com.Library.Book_Management.Repository.PrintedBookRepo;
import com.Library.Book_Management.Service.AuthorService;
import com.Library.Book_Management.models.Author;
import com.Library.Book_Management.models.PrintedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add-author")
    public ResponseEntity<Author> addAuthor(Author author){
        return new ResponseEntity<>(authorService.addAuthor(author),HttpStatus.OK);
    }
    @GetMapping("/get-Authors")
    public List<Author> getAuthorsByAgeAndRating(@RequestParam int age, @RequestParam float rating){
        return authorService.getAuthorsByAgeAndRating(age,rating);
    }
}
