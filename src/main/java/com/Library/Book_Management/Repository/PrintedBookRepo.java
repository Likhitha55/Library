package com.Library.Book_Management.Repository;

import com.Library.Book_Management.models.PrintedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrintedBookRepo extends JpaRepository<PrintedBook, String> {
}
