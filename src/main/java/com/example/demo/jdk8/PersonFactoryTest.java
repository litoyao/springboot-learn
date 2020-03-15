package com.example.demo.jdk8;

import java.util.function.Predicate;

public class PersonFactoryTest {

    public static void main(String[] args) {
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");

        System.out.println(person.firstName);

        Predicate<String> predicate = (String s) -> s.length() > 0;

        System.out.println(predicate.test("foo"));              // true
        System.out.println(predicate.negate().test("foo"));     // false

    }
}
