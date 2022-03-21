package com.suhan.demo.models;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "tester")
public class Employee {
    private String firstName;
    private String surName;
    private String emailAddress;

    // Overriding toString method. toString method is used to print the object in
    // console.
    @Override
    public String toString() {
        return "firstName=" + firstName + ", surName=" + surName + ", emailAddress=" + emailAddress;
    }
}
