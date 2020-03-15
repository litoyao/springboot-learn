package com.example.demo.jdk8;

class Person {
    String firstName;
    String lastName;
    int age;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=18;
    }

    Person(String firstName, String lastName,int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=age;
    }

    public  String toString(){
        return "firstName:"+firstName+", lastName:"+lastName+", age:"+age;
    }
}