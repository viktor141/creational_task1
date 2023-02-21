package org.example;

import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;

    public Person(String name, String surname) {
        this(name, surname, -1);
    }

    public Person(String name, String surname, int age) {
        this(name, surname, age, null);
    }

    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
    }

    public boolean hasAge() {
        return !(age == -1);
    }

    public boolean hasAddress() {
        return city != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if(hasAge()){
            return OptionalInt.of(age);
        }
        return OptionalInt.empty();
    }

    public String getAddress() {
        return city;
    }

    public void setAddress(String address) {
        this.city = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAge(0).setAddress(city);
    }

    @Override
    public String toString() {
        return "[Name: " + name + ", Last Name: " + surname + ", Age: " + (hasAge() ? age : "unspecified") + ", City: " + (hasAddress() ? city : "unspecified") + "]";
    }

    @Override
    public int hashCode() {
        return name.hashCode() + surname.hashCode() + age + city.hashCode();
    }
}
