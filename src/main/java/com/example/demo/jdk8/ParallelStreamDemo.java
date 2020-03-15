package com.example.demo.jdk8;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreamDemo {

    public List<String> generateList(){
        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        return values;
    }

    public void sort(List<String> values){
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public void paralleSort(List<String> values){
        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
    }

    public static void main(String[] args){

        Clock clock =Clock.systemDefaultZone();
       System.out.println(clock.millis());

        Instant instant=clock.instant();
        Date date =Date.from(instant);
        System.out.println(date);

        System.out.println(ZoneId.getAvailableZoneIds());

        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
        Stream.generate(() -> new Random().nextInt(100)).limit(15).forEach(System.out::println);


        Stream.generate(new PersonSupplier()).limit(5).forEach(System.out::println);

    }
}
