package com.shieory.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author shieory
 * @version : ThreadDemo.java, v 0.1 2019年04月21日 14:03 shieory Exp $
 */
public class ThreadDemo {

    public static void main(String[] args) throws Exception {
        HelloThread(" test thread xxxx");
    }

    public static void HelloThread(String str) throws Exception {
        System.out.println("继承Thread的线程开始了");
        new thread1(str).start();

        System.out.println("实现 runable的线程开始了");
        new Thread(new thread2(str)).start();

        System.out.println("实现callable的线程开始了");
        FutureTask<String> futureTask = new FutureTask<>(new thread3<String>(str));
        new Thread(futureTask).start();
        System.out.println("获取callable的返回值 " + futureTask.get());
    }

    public static class thread1 extends Thread {
        private String str;

        public thread1(String str) {
            super(thread1.class.getSimpleName());
            this.str = str;
        }

        @Override
        public void run() {
            try {
                sleep(3233);
                System.out.println("the first implementation" + str);
            } catch (Exception ex) {
                System.out.println("exception");
            }

        }
    }

    public static class thread2 implements Runnable {
        private String str;

        public thread2(String str) {
            this.str = str;
        }

        @Override
        public void run() {
            System.out.println("the second implementaion" + str);
        }

    }

    public static class thread3<String> implements Callable<String> {
        private String str;

        public thread3(String str) {
            this.str = str;
        }

        @Override
        public String call() throws Exception {
            System.out.println("the third implementation" + str);
            return str;
        }
    }
}
