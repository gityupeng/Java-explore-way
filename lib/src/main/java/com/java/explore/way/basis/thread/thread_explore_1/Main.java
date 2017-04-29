package com.java.explore.way.basis.thread.thread_explore_1;

/**
 * Created by yu on 2017/4/29.
 */

public class Main {

    public static void main(String [] args){

        Dog dog = new Dog();
        ThreadSn threadSY = new ThreadSn("0001",dog);
        ThreadReLock threadReLock = new ThreadReLock("0002",dog);
        threadSY.start();
        threadReLock.start();


        //没同步 打印的数据结果
//        线程ID==0001---dog age == 6
//        线程ID==0002---dog age == 6
//        线程ID==0001---dog age == 2
//        线程ID==0002---dog age == 7
//        线程ID==0001---dog age == 3
//        线程ID==0002---dog age == 8
//        线程ID==0001---dog age == 4
//        线程ID==0002---dog age == 9
//        线程ID==0002---dog age == 10
//        线程ID==0001---dog age == 5

        /*dog对象赋值时，加上synchronized之后，达到了同步的效果，没有出现值错乱
        synchronized (this){
                mDog.age = i;
                System.out.println("线程ID==" + threadId + "---dog age == "+ mDog.age);
            }
            打印的数据
        *   线程ID==0001---dog age == 1
            线程ID==0002---dog age == 6
            线程ID==0001---dog age == 2
            线程ID==0002---dog age == 7
            线程ID==0001---dog age == 3
            线程ID==0002---dog age == 8
            线程ID==0001---dog age == 4
            线程ID==0002---dog age == 9
            线程ID==0001---dog age == 5
            线程ID==0002---dog age == 10
                 */

        /*使用ThreadReLock，实现了跟synchronized一样的效果；代码如下；

        心得：通过查看打印的日志发现synchronized锁住的是一块代码，执行完之后，会迅速释放掉lock,全权有系统控制;
              reentrantLock加锁和释放锁都有自己控制，比synchronized灵活；

         reentrantLock.lock();
            try {
                mDog.age = i;
                System.out.println("线程ID==" + threadId + "---dog age == "+ mDog.age);
            }
            finally {
                reentrantLock.unlock();
            }

            线程ID==0001---dog age == 1
            线程ID==0001---dog age == 2
            线程ID==0001---dog age == 3
            线程ID==0001---dog age == 4
            线程ID==0001---dog age == 5
            线程ID==0002---dog age == 5
            线程ID==0002---dog age == 7
            线程ID==0002---dog age == 8
            线程ID==0002---dog age == 9
            线程ID==0002---dog age == 10*/

    }
}
