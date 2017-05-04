package com.java.explore.way.basis.thread.thread_explore_1.test;

import com.java.explore.way.basis.thread.thread_explore_1.test.Dog;

/**
 * Created by yu on 2017/4/29.
 */

public class ThreadB extends Thread {

    public String threadId;
    public Dog mDog;


    public ThreadB(String id, Dog dog){
        threadId = id;
        mDog = dog;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 6; i<= 10; i++){
            mDog.setAge(i,threadId);
        }
    }
}
