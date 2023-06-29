package com.ext.prep.deadlock;

public class ThreadDemo {

    public static void main(String[] args) {
        final Object resource1 = "Resource-1";
        final Object resource2 = "Resuorce-1";

        Thread thread1 = new Thread(()->{

            synchronized (resource1){
                System.out.println("Thread 1 locked resource1 ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2){
                    System.out.println("Thread 1 locked resource2 ");
                }
            }
        });

        Thread thread2 = new Thread(()->{
            synchronized (resource2){
                System.out.println("Thread 2 locked resource2 ");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1){
                    System.out.println("Thread 2 locked resource1 ");
                }
            }
        });

        thread1.setName("Helper-1");
        thread2.setName("Helper-1");

        thread1.start();
        thread2.start();
    }
}
