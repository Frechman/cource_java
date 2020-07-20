package ru.frechman.concurrent;

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start main");
        System.out.println(Thread.activeCount());

        Thread thread = new Thread(() -> {
            try {
                System.out.println("Starting loading...");
                Thread.sleep(3000L);
                System.out.println("Loaded.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setName("my_thread");
        thread.start();

        Thread.sleep(1000L);
        System.out.println(thread.getName() + " : state = " + thread.getState());

        System.out.println("end main");
    }
}
