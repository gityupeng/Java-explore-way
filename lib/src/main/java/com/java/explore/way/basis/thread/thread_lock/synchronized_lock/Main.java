package com.java.explore.way.basis.thread.thread_lock.synchronized_lock;

/**
 * Created by yu on 2017/4/29.
 * 多线程轮询打印1，2，3,synchronized实现
 */

public class Main {

    public static boolean runFir = true;
    public static boolean runSec;
    public static boolean runThr;


    public static void main(String [] args){


        Object lock = new Object();

        Thread threadA = new ThreadA(lock);
        threadA.start();
        Thread threadB = new ThreadB(lock);
        threadB.start();
        Thread threadC = new ThreadC(lock);
        threadC.start();




    }
}
