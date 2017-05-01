package com.jeee.example.bookstorage;

import java.util.UUID;
import java.util.logging.Logger;

import javax.inject.Inject;

import com.jeee.example.bookstorage.api.NumberGenerator;
import com.jeee.example.bookstorage.api.annotations.EightDigits;
import com.jeee.example.bookstorage.api.annotations.Loggable;

@EightDigits
public class IssnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String issn = "8-" + UUID.randomUUID().toString();
        logger.info("Generated ISSN: " + issn);
        return issn;
    }

}
