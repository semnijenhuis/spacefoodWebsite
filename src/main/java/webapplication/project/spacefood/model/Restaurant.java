package webapplication.project.spacefood.model;

import java.util.ArrayList;

public class Restaurant {
    private Menu menu;
    private String name;
    private String address;
    private String zipCode;
    private String City;
    private String quote;
    private String description;

    public Restaurant(String name, String address, String zipCode, String city, String quote, String description) {
        this.name = name;
        this.address = address;
        this.zipCode = zipCode;
        City = city;
        this.quote = quote;
        this.description = description;
        menu = new Menu();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getQuote() {
        return quote;
    }



    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

