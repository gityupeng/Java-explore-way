package com.java.explore.way.basis.thread.thread_explore_2;

/**
 * Created by yu on 2017/4/29.
 */

public class ThreadC extends Thread {

    public Object mLock;

    public ThreadC(Object lock){
        mLock = lock;
    }

    @Override
    public void run() {
        while (true){
            synchronized (mLock){
                try {
                    if (Main.runThr){
                        System.out.println("线程id=="+ Thread.currentThread() + "打印数字==" + 3);
                        Thread.sleep(2000);
                        Main.runSec = false;
                        Main.runThr = false;
                        Main.runFir = true;
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
