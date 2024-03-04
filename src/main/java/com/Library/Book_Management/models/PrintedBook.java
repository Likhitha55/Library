package com.Library.Book_Management.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PrintedBook {
    @Id
    String printedBookName;
    int pages;
    String authorName;
}
