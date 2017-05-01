package com.jeee.example.bookstorage;

import java.util.UUID;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.jeee.example.bookstorage.api.NumberGenerator;
import com.jeee.example.bookstorage.api.annotations.Loggable;
import com.jeee.example.bookstorage.api.annotations.ThirteenDigits;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String isbn = "13-" + UUID.randomUUID().toString();
        logger.info("Generated ISBN: " + isbn);
        return isbn;
    }

}
