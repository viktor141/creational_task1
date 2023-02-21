package org.example;

public class PersonBuilder {

    private String name = null;
    private String surname = null;
    private int age = -1;
    private String city = null;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age can't be below zero");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.city = address;
        return this;
    }

    public Person build() {
        if (name == null) {
            throw new IllegalStateException("Name can't be blank");
        }
        if (surname == null) {
            throw new IllegalStateException("Last Name can't be blank");
        }

        return new Person(name, surname, age, city);
    }
}
