package com.jeee.example.bookstorage;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book created = bookService.createBook("book title", 12f, "book description");
        System.out.println(created);
        weld.shutdown();
    }

}
