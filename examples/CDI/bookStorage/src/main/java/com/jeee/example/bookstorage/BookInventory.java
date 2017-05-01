package com.jeee.example.bookstorage;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.jeee.example.bookstorage.api.annotations.Loggable;

@Loggable
public class BookInventory {

    @Inject
    private Logger logger;
    private List<Book> inventory = new ArrayList<>();

    public void addBook(@Observes Book book) {
        inventory.add(book);
        logger.info("Book was added in inventory");
    }
}
