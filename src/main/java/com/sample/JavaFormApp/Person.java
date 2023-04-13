package com.sample.JavaFormApp;

public class Person {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String email;
    private String sex;

    public Person(String firstName, String lastName, String birthDate, String email, String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)\nBorn on %s\n%s\n\n", firstName, lastName, sex, birthDate, email);
    }
}
