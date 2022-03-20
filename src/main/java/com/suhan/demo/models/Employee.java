package com.suhan.demo.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Employee {
    private String FirstName;
    private String SurName;
    private String EmailAddress;

    public Employee(String firstname, String surname, String emailadress) {
        this.FirstName = firstname;
        this.SurName = surname;
        this.EmailAddress = emailadress;

    }

    public String printEmployee() {
        return "Firstname=" + FirstName + ", Surname=" + SurName + ", EmailAddress=" + EmailAddress;
    }
}
