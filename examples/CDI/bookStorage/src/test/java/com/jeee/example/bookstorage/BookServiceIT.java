package com.jeee.example.bookstorage;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Assert;
import org.junit.Test;

public class BookServiceIT {

    @Test
    public void testMockGenerator() {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService bookService = container.instance().select(BookService.class).get();
        Book created = bookService.createBook("book title", 12f, "book description");
        Assert.assertTrue(created.getNumber().startsWith("decorates-mock"));
        weld.shutdown();
    }
}
