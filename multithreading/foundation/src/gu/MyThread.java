package gu;

import net.jcip.annotations.NotThreadSafe;

public class MyThread implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }

    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread myThread = new MyThread();
            new Thread(myThread,"thread"+i).start();
        }
    }
}
