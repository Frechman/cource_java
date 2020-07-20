package ru.frechman.concurrent;

public class ConcurrentOutput {

    public static void main(String[] args) throws InterruptedException {
        Thread anotherThread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        anotherThread.start();

        System.out.println(Thread.currentThread().getName());

        Thread second = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        second.start();

        System.out.println(Thread.currentThread().getName());
    }
}
