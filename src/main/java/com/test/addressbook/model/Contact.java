package com.test.addressbook.model;


import com.test.addressbook.validator.ValidPhoneNumber;

import javax.validation.constraints.NotBlank;

public class Contact {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @ValidPhoneNumber(message = "Not a valid phone number")
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("%s,%s",name, number);
    }
}
