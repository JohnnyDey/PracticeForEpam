package com.home.work.memory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OutOfMemory {

    public static void main(String... a){
        makeOutOfMemory();
    }

    //options for IDEA: Help -> Edit Custom VM Options
    private static void makeOutOfMemory() {
        List<Date> list = new ArrayList<>();
        while (true) {
            list.add(new Date());
        }
    }
}