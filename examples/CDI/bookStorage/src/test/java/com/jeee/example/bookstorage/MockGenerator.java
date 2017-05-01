package com.jeee.example.bookstorage;

import java.util.UUID;
import java.util.logging.Logger;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.jeee.example.bookstorage.api.NumberGenerator;
import com.jeee.example.bookstorage.api.annotations.Loggable;
import com.jeee.example.bookstorage.api.annotations.ThirteenDigits;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    public String generateNumber() {
        String mock = "mock" + UUID.randomUUID().toString();
        logger.info("Generated mock: " + mock);
        return mock;
    }

}
