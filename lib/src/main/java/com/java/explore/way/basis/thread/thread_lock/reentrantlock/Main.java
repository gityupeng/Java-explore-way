package com.java.explore.way.basis.thread.thread_lock.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yu on 2017/5/1.
 * 主要是学习ReentrantLock锁机制；
 * 一下代码实现了多线程轮询打印1，2，3；开启三个线程，每个线程负责打印一个数字，需做到顺序打印；
 * 实现思路：线程打印完之后，循环进入等待状态，然后通过Condition的signal方法去唤醒目标线程；
 *
 * 心得体会：
 * 通过使用ReentrantLock发现，比synchronized更加灵活和方便，锁的开启和释放都可以手动进行；不需要JVM进行管理；
 * 可以通过Condition有选择性的唤醒目标线程；比notify和notifyAll,更加灵活。
 *
 */

public class Main {

    public static int mPrintNum = 1;

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
                    while (mPrintNum != 1) {
                        conditionA.await();
                    }
                    System.out.println("打印==1");
                    TimeUnit.SECONDS.sleep(1);
                    mPrintNum = 2;
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
                    while (mPrintNum != 2) {
                        conditionB.await();
                    }
                    System.out.println("打印==2");
                    TimeUnit.SECONDS.sleep(1);
                    mPrintNum = 3;
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
                    while (mPrintNum != 3) {
                        conditionC.await();
                    }
                    System.out.println("打印==3");
                    TimeUnit.SECONDS.sleep(1);
                    mPrintNum = 1;
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
