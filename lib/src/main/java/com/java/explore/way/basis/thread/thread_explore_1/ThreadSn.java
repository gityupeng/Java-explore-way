package com.java.explore.way.basis.thread.thread_explore_1;


/**
 * Created by yu on 2017/4/29.
 * 线程synchronized测试
 */

public class ThreadSn extends Thread{

    public String threadId;
    public Dog mDog;

    public ThreadSn(String id, Dog dog){
        threadId = id;
        mDog = dog;
    }

    public void run() {

        for (int i = 1;i <= 5;i++){
            synchronized (this){
                mDog.age = i;
                System.out.println("线程ID==" + threadId + "---dog age == "+ mDog.age);
            }
        }

    }
}
