package com.java.explore.way.basis.thread.thread_explore_1;


import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yu on 2017/4/29.
 *
 */

public class ThreadReLock extends Thread {

    public String threadId;
    public Dog mDog;

    public ReentrantLock reentrantLock;

    public ThreadReLock(String id,Dog dog){
        threadId = id;
        mDog = dog;
        reentrantLock = new ReentrantLock();
    }


    public void run() {

        for (int i = 6;i <= 10;i++){
            reentrantLock.lock();
            try {
                mDog.age = i;
                System.out.println("线程ID==" + threadId + "---dog age == "+ mDog.age);
            }
            finally {
                reentrantLock.unlock();
            }
        }
    }
}
