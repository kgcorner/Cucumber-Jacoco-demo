package com.kgcorner.Demo.BDD.resource;

import com.kgcorner.Demo.BDD.Model.Book;
import com.kgcorner.Demo.BDD.Store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by admin on 3/15/2018.
 */
@RestController
public class BookResource {

    @GetMapping("/books")
    public List<Book> getAllBooks(@RequestParam("count") int itemsCount) {
        return Store.getBooks(itemsCount);
    }

    @GetMapping("/search/books")
    public List<Book> getAllBooks(@RequestParam("name") String name) {
        return Store.searchBook(name);
    }


}
