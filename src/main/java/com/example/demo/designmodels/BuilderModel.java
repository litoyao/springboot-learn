package com.example.demo.designmodels;

public class BuilderModel {

    public static void main(String[] args) {
        Person person = new PersonBuilder().name("yao")
                .address("no. 3")
                .age(21)
                .weight(120)
                .build();

        System.out.println(person.getName());
    }
}

class Person {
    private String name;
    private String address;
    private int age;
    private int sex;
    private int height;
    private int weight;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return sex;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
}

class PersonBuilder {

    Person person;

    PersonBuilder() {
        person = new Person();
    }

    public Person build() {
        return this.person;
    }

    public PersonBuilder name(String name) {
        this.person.setName(name);
        return this;
    }

    public PersonBuilder address(String address) {
        this.person.setAddress(address);
        return this;
    }

    public PersonBuilder weight(int weight) {
        this.person.setWeight(weight);
        return this;
    }

    public PersonBuilder age(int age) {
        this.person.setAge(age);
        return this;
    }
}