package com.example.demo.stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WC {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\sample\\The Odyssey - Homer.txt"));

        reader.lines()
                .map(line -> line.replaceAll("[^a-zA-Z]", " "))
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .collect(Collectors.groupingBy((x) -> x))
                .values()
                .stream()
                .map(x -> new Item(x.get(0), x.size()))
                .sorted((x, y) -> y.count - x.count)
                .forEach(x -> System.out.println(x.word + "->" + x.count));

    }
}

class Item {
    String word;
    Integer count;

    Item(String word, Integer count) {
        this.word = word;
        this.count = count;
    }
}