package com.java.explore.way.basis.thread.thread_lock.synchronized_lock;

/**
 * Created by yu on 2017/4/29.
 */

public class ThreadB extends Thread {

    public Object mLock;

    public ThreadB(Object lock){
        mLock = lock;
    }

    @Override
    public void run() {
        while (true){
            synchronized (mLock){
                try {
                    if (Main.runSec){
                        System.out.println("线程id=="+ Thread.currentThread() + "打印数字==" + 2);
                        Thread.sleep(2000);
                        Main.runSec = false;
                        Main.runThr = true;
                        Main.runFir = false;
                        mLock.notifyAll();
                    }else {
                        mLock.wait();
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        }
    }



}
