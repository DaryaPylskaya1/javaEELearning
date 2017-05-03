package com.javaee.example.cdStorage;

import java.math.BigDecimal;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        CDItemService cdService = container.instance().select(CDItemService.class).get();
        CDItem invalid = new CDItem(null, BigDecimal.TEN, null, 0, null);
        System.out.println(invalid.toString() + " is valid[" + cdService.validateCD(invalid) + "]");
        CDItem valid = new CDItem("title", BigDecimal.TEN, null, 0, null);
        System.out.println(valid.toString() + " is valid[" + cdService.validateCD(valid) + "]");
    }
}
