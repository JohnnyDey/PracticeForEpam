package com.home.work.memory;

public class StackOverflow {

    public static void main(String... a){
        selfRecursive();
    }

    private static void selfRecursive(){
        selfRecursive();
    }
}
