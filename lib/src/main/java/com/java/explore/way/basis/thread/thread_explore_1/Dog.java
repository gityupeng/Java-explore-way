package com.java.explore.way.basis.thread.thread_explore_1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yu on 2017/4/29.
 * 测试同步锁
 */

public class Dog {

    public int age;

    public ReentrantLock lock = new ReentrantLock();

//    public synchronized void setAge(int age,String threadId) {
//            this.age = age;
//            System.out.println("线程ID==" + threadId + "---dog age == "+ age);
//    }


//    public  void setAge(int age,String threadId) {
//        synchronized (this){
//            this.age = age;
//            System.out.println("线程ID==" + threadId + "---dog age == "+ age);
//        }
//    }

//    public  void setAge(int age,String threadId) {
//        lock.lock();
//        try {
//            this.age = age;
//            System.out.println("线程ID==" + threadId + "---dog age == "+ age);
//        }finally {
//            lock.unlock();
//        }
//
//    }

    //ThreadLocal也能达到同步的效果
    public  void setAge(int age,String threadId) {
            ThreadLocal local = new ThreadLocal();
            local.set(this);
            this.age = age;
            System.out.println("线程ID==" + threadId + "---dog age == "+ age);
    }

}
