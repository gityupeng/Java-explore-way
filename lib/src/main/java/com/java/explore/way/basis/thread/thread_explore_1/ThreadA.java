package com.java.explore.way.basis.thread.thread_explore_1;



/**
 * Created by yu on 2017/4/29.
 *
 */

public class ThreadA extends Thread {

    public String threadId;
    public Dog mDog;


    public ThreadA(String id, Dog dog){
        threadId = id;
        mDog = dog;
    }


    public void run() {
        for (int i = 1; i<= 5; i++){
            mDog.setAge(i,threadId);
        }

    }
}
