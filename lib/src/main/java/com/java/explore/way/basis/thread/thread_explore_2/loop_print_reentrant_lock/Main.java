package com.java.explore.way.basis.thread.thread_explore_2.loop_print_reentrant_lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yu on 2017/5/1.
 * 测试多线程打印1，2，3 使用ReentrantLock 实现
 *
 */

public class Main {

    public static boolean mFirst;
    public static boolean mSecond = true;
    public static boolean mThird;

    public static ReentrantLock reentrantLock = new ReentrantLock();
    public static Condition conditionA = reentrantLock.newCondition();
    public static Condition conditionB = reentrantLock.newCondition();
    public static Condition conditionC = reentrantLock.newCondition();

    public static void main(String [] args){

        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();
        ThreadC threadC = new ThreadC();
        threadA.start();
        threadB.start();
        threadC.start();
    }

    public static class ThreadA extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                reentrantLock.lock();
                try {
                    while (mFirst) {
                        conditionA.await();
                    }
                    System.out.println("打印==1");
                    TimeUnit.SECONDS.sleep(1);
                    mFirst = true;
                    mSecond = false;
                    conditionB.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }
    }

    public static class ThreadB extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                reentrantLock.lock();
                try {
                    while (mSecond) {
                        conditionB.await();
                    }
                    System.out.println("打印==2");
                    TimeUnit.SECONDS.sleep(1);
                    mSecond = true;
                    mThird = false;
                    conditionC.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }

        }


    }


    public static class ThreadC extends Thread {

        @Override
        public void run() {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                reentrantLock.lock();
                try {
                    while (mThird) {
                        conditionC.await();
                    }
                    System.out.println("打印==3");
                    TimeUnit.SECONDS.sleep(1);
                    mThird = true;
                    mFirst = false;
                    conditionA.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }

        }
    }


}
