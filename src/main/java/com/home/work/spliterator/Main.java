package com.home.work.spliterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class Main {

    public static void main(String... a){
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 100; i++){
            list.add(String.valueOf(i));
        }
        MySpliterator<String> spliterator = new MySpliterator<>(list);
        System.out.println("Estimate origin:" + spliterator.estimateSize());

        Spliterator<String> firstPartSpliterator = spliterator.trySplit();
        System.out.println("Estimate (s1):" + firstPartSpliterator.estimateSize());
        System.out.println("Estimate (s2):" + spliterator.estimateSize());

        Thread thread1 = new Thread(() -> spliterator.forEachRemaining(System.out::println));
        Thread thread2 = new Thread(() -> {
            boolean hasNest;
            do{
                hasNest = firstPartSpliterator.tryAdvance(System.out::println);
            }while (hasNest);
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ignored) {}

        System.out.println("Estimate (s1):" + firstPartSpliterator.estimateSize());
        System.out.println("Estimate (s2):" + spliterator.estimateSize());
    }
}
