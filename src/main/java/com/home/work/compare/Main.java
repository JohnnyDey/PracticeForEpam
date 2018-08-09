package com.home.work.compare;

import java.util.*;

public class Main {

    public static void main(String... a){
        testWithComparator();
        System.out.println("---------------");
        testComparableObjcts();
    }


    private static void testWithComparator(){
        List<IncomparableStudent> list = new ArrayList<>();

        list.add(new ComparableStudent("Mark", 10));
        list.add(new IncomparableStudent("Tom", 10));
        list.add(new IncomparableStudent("Sam", 18));
        list.add(new IncomparableStudent("Tom", 18));
        list.add(new IncomparableStudent("Tom", 15));
        list.add(new IncomparableStudent("Jessika", 15));
        list.add(new IncomparableStudent("Lenny", 16));

        System.out.println(Arrays.toString(list.toArray()));
        list.sort((o1, o2) -> {
            int result = o1.getAge().compareTo(o2.getAge());
            if(result != 0) return result;
            return o1.getName().compareTo(o2.getName());
        });
        System.out.println(Arrays.toString(list.toArray()));
    }

    private static void testComparableObjcts(){
        List<ComparableStudent> list = new ArrayList<>();

        list.add(new ComparableStudent("Mark", 10));
        list.add(new ComparableStudent("Tom", 10));
        list.add(new ComparableStudent("Sam", 18));
        list.add(new ComparableStudent("Tom", 18));
        list.add(new ComparableStudent("Tom", 15));
        list.add(new ComparableStudent("Jessika", 15));
        list.add(new ComparableStudent("Lenny", 16));

        System.out.println(Arrays.toString(list.toArray()));
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

}
