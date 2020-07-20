package ru.frechman.concurrent;

public class Wget {

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i <= 100; i++) {
                System.out.print("\rLoading : " + i + "%");
                try {
                    Thread.sleep(10L); //1000L = 1sec
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("Loaded.");

        }).start();
    }
}
