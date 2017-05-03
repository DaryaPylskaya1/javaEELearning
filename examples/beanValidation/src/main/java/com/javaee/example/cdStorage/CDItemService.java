package com.javaee.example.cdStorage;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.Validator;

public class CDItemService {

    @Inject
    private Validator validator;
    private List<CDItem> cds = new ArrayList<>();

    public boolean validateCD(CDItem item) {
        return validator.validate(item).size() == 0;
    }

    public void addValidCd(@Valid CDItem item) {
        cds.add(item);
    }
}
