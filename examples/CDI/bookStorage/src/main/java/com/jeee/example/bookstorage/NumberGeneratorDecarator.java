package com.jeee.example.bookstorage;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

import com.jeee.example.bookstorage.api.NumberGenerator;
import com.jeee.example.bookstorage.api.annotations.Loggable;
import com.jeee.example.bookstorage.api.annotations.ThirteenDigits;

@Loggable
@Decorator
public class NumberGeneratorDecarator implements NumberGenerator {

    @Inject
    @ThirteenDigits
    @Delegate
    private NumberGenerator numberGenerator;

    @Override
    public String generateNumber() {
        String number = numberGenerator.generateNumber();
        return "decorates-" + number;
    }

}
