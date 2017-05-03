package com.javaee.example.cdStorage;

import javax.validation.constraints.NotNull;

import com.javaee.example.cdStorage.annotations.ZipCode;

public class Address {

    @NotNull
    private String street1;
    private String street2;
    @NotNull
    private String city;
    private String state;
    @ZipCode
    private String zipCode;
    @NotNull
    private String country;

    public Address(String street1, String street2, String city, String state, String zipCode, String country) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        result = prime * result + ((street1 == null) ? 0 : street1.hashCode());
        result = prime * result + ((street2 == null) ? 0 : street2.hashCode());
        result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
        Address other = (Address) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (state == null) {
            if (other.state != null)
                return false;
        } else if (!state.equals(other.state))
            return false;
        if (street1 == null) {
            if (other.street1 != null)
                return false;
        } else if (!street1.equals(other.street1))
            return false;
        if (street2 == null) {
            if (other.street2 != null)
                return false;
        } else if (!street2.equals(other.street2))
            return false;
        if (zipCode == null) {
            if (other.zipCode != null)
                return false;
        } else if (!zipCode.equals(other.zipCode))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Address [street1=" + street1 + ", street2=" + street2 + ", city=" + city + ", state=" + state
                + ", zipCode=" + zipCode + ", country=" + country + "]";
    }

}
