package com.Library.Book_Management.Service;

import com.Library.Book_Management.Repository.AuthorRepo;
import com.Library.Book_Management.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo authorRepo;
    public Author addAuthor(Author author){
        Author a = new Author();
        a.setAuthorName(author.getAuthorName());
        a.setAge(author.getAge());
        a.setGender(author.getGender());
        a.setRating(author.getRating());
        authorRepo.save(a);
        return authorRepo.findById(a.getAuthorName()).orElse(null);
    }
    public List<Author> getAuthorsByAgeAndRating(int age, float rating){
        List<Author> authorsToBeReturned = new ArrayList<>();
        for(Author a : authorRepo.findAll()){
            if((a.getAge() < age) && (a.getRating() > rating)){
                authorsToBeReturned.add(authorRepo.findById(a.getAuthorName()).orElse(null));
            }
        }
        return authorsToBeReturned;
    }
}
