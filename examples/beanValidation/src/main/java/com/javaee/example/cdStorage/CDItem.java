package com.javaee.example.cdStorage;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.javaee.example.cdStorage.validationGroups.PrintingCatalog;

public class CDItem {

    @NotNull
    private String title;
    @NotNull
    @DecimalMin(value = "0")
    private BigDecimal price;
    @NotNull(groups = PrintingCatalog.class, message = "Description shouldn't be null")
    @Size(max = 200)
    @Pattern(regexp = "^[a-zA-Z0-9.,]+")
    private String description;
    private int numberOfCds = 1;
    private Float maxDuration;

    public CDItem(String title, BigDecimal price, String description, @DecimalMin(value = "1") int numberOfCds,
            Float maxDuration) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.numberOfCds = numberOfCds;
        this.maxDuration = maxDuration;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getNumberOfCds() {
        return numberOfCds;
    }

    public Float getMaxDuration() {
        return maxDuration;
    }

    @NotNull
    public BigDecimal calculatePrice(@DecimalMin(value = "0") BigDecimal rate) {
        return price.multiply(rate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((maxDuration == null) ? 0 : maxDuration.hashCode());
        result = prime * result + numberOfCds;
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CDItem other = (CDItem) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (maxDuration == null) {
            if (other.maxDuration != null)
                return false;
        } else if (!maxDuration.equals(other.maxDuration))
            return false;
        if (numberOfCds != other.numberOfCds)
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CDItem [title=" + title + ", price=" + price + ", description=" + description + ", numberOfCds="
                + numberOfCds + ", maxDuration=" + maxDuration + "]";
    }

}
