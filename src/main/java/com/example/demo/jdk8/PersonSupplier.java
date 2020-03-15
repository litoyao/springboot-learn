package com.example.demo.jdk8;

import java.util.Random;
import java.util.function.Supplier;

public class PersonSupplier implements Supplier<Person> {

    private int index = 1;
    private Random random = new Random();

    @Override
    public Person get() {
        return new Person("yao", "" + index++, random.nextInt(80));
    }
}
