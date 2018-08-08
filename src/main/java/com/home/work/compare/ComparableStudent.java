package com.home.work.compare;

public class ComparableStudent extends IncomparableStudent implements Comparable<ComparableStudent>{

    public ComparableStudent(String name, int age) {
        super(name, age);
    }

    @Override
    public int compareTo(ComparableStudent o) {
        int result = this.getName().compareTo(o.getName());
        if(result != 0) return result;
        return this.getAge().compareTo(o.getAge());
    }
}
