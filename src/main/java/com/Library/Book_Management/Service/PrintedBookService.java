package com.Library.Book_Management.Service;

import com.Library.Book_Management.Repository.AuthorRepo;
import com.Library.Book_Management.Repository.PrintedBookRepo;
import com.Library.Book_Management.models.Author;
import com.Library.Book_Management.models.PrintedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrintedBookService {
    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    PrintedBookRepo printedBookRepo;
    public PrintedBook addPrintedBook(PrintedBook printedBook){
        PrintedBook PB = new PrintedBook();
        PB.setPrintedBookName(printedBook.getPrintedBookName());
        PB.setPages(printedBook.getPages());
        PB.setAuthorName(printedBook.getAuthorName());
        printedBookRepo.save(PB);

        //Adding the book to the list under that purticular author
        Author authorOfThisBook = new Author();
        authorOfThisBook = authorRepo.findById(printedBook.getAuthorName()).orElse(null);
        List<PrintedBook> printedBookList = authorOfThisBook.getPrintedBookList();
        printedBookList.add(PB);
        authorOfThisBook.setPrintedBookList(printedBookList);
        return printedBookRepo.findById(PB.getPrintedBookName()).orElse(null);
    }
    public void updatePages(String name , int pages){
        printedBookRepo.findById(name).orElse(null).setPages(pages);
    }
    public int getNoOfPrintedBooksByAuthorsRating(float rating){
        List<Author> authorsHavingRating = new ArrayList<>();
        for(Author a : authorRepo.findAll()){
            if(a.getRating() > rating){
                authorsHavingRating.add(a);
            }
        }
        int printedBookCount= 0;
        for(Author a : authorsHavingRating){
            printedBookCount+=a.getPrintedBookList().size();
        }
        return printedBookCount;
    }
}
