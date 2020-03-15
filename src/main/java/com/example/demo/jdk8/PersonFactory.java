package com.example.demo.jdk8;

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}