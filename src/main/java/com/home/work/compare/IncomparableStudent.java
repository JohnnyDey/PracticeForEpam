package com.home.work.compare;

public class IncomparableStudent {
    private String name;
    private Integer age;

    public IncomparableStudent(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "{name='" + name + ", age=" + age + "}";
    }
}
