package com.Library.Book_Management.Repository;

import com.Library.Book_Management.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, String> {
}
