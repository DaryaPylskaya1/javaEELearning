package com.jeee.example.bookstorage;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.jeee.example.bookstorage.api.NumberGenerator;
import com.jeee.example.bookstorage.api.annotations.Loggable;
import com.jeee.example.bookstorage.api.annotations.ThirteenDigits;

@Loggable
public class BookService {

    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;
    @Inject
    private Event<Book> bookCreateEvent;

    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description, null);
        book.setNumber(numberGenerator.generateNumber());
        bookCreateEvent.fire(book);
        return book;
    }
}
