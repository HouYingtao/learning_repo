package com.hyt.thread;

/**
 * @author hou
 * @create 2019-08-18 22:08
 **/
public class ThreadDemo {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            int ticket = 100;

            // 锁一定要放到run方法的外面。
            Object lock = new Object();

            @Override
            public void run() {
                synchronized (lock) {
                    while (ticket > 0) {
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + " → " + ticket--);
                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
