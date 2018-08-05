package com.home.work.Immutable;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ImmutableTest {

    public static void main(String... a){
        ImmutablePerson maxim = ImmutablePerson.getInstance("Maxim", getDate(1980, 1, 1));

        tryModifyParams(maxim);
        createNewPerson(maxim);
    }

    private static void tryModifyParams(ImmutablePerson person){
        System.out.println("Try to modify params");
        System.out.println("Person before changes: " + person);

        Date birthday = person.getBirthday();
        birthday.setTime(new Date().getTime());

        String name = person.getName();
        name = "Not Maxim";

        System.out.println("Person after changes: " + person + "\n\n");
    }

    private static void createNewPerson(ImmutablePerson person){
        ImmutablePerson denis = ImmutablePerson.getInstance("Denis", getDate(1990, 10, 10));
        System.out.println("New instance: " + denis);
        System.out.println("Old instance: " + person);
    }

    private static Date getDate(int year, int month, int day) {
        Calendar instance = Calendar.getInstance(TimeZone.getDefault());
        instance.set(Calendar.YEAR, year);
        instance.set(Calendar.MONTH, month);
        instance.set(Calendar.DAY_OF_MONTH, day);
        return instance.getTime();
    }

}
