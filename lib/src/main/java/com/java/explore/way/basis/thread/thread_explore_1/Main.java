package com.java.explore.way.basis.thread.thread_explore_1;

/**
 * Created by yu on 2017/4/29.
 */

public class Main {

    public static void main(String [] args){

        Dog dog = new Dog();
        ThreadA threadA = new ThreadA("1",dog);
        threadA.start();
        ThreadB threadb = new ThreadB("2",dog);
        threadb.start();

    }
}
