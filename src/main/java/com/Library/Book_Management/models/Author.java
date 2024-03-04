package com.Library.Book_Management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Author {
    @Id
    String authorName;
    int age;
    char gender;
    float rating;

    @OneToMany
    List<PrintedBook> printedBookList;
}
