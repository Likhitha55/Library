package com.Library.Book_Management.Controller;

import com.Library.Book_Management.Service.PrintedBookService;
import com.Library.Book_Management.models.PrintedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class PrintedBookController {
    @Autowired
    PrintedBookService printedBookService;

    @PostMapping("/add-book")
    public ResponseEntity<PrintedBook> addPrintedBook(@RequestBody PrintedBook printedBook) {
        return new ResponseEntity<>(printedBookService.addPrintedBook(printedBook), HttpStatus.OK);
    }

    @PutMapping("/update-pages")
    public void updatePages(@RequestParam String name, @RequestParam int pages) {
        printedBookService.updatePages(name, pages);
    }
    @GetMapping("/get-book-count")
    public int getNoOfPrintedBooksByAuthorsRating(@RequestParam float rating){
        return printedBookService.getNoOfPrintedBooksByAuthorsRating(rating);
    }
}
