package ru.frechman.concurrent;

public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("startTHREAD= " + Thread.currentThread().getName() + " STATE= " + Thread.currentThread().getState());

        Thread first = new Thread(() ->
           System.out.println("run():THREAD= " + Thread.currentThread().getName() + " STATE= " + Thread.currentThread().getState())
        );
        first.setName("thread#1");

        Thread second = new Thread(() ->
           System.out.println("run():THREAD= " + Thread.currentThread().getName() + " STATE= " + Thread.currentThread().getState())
        );
        second.setName("thread#2");

        // NEW - создали поток, но не запустили=не вызвали start()
        System.out.println("THREAD= " + first.getName() + " STATE= " + first.getState());
        System.out.println("THREAD= " + second.getName() + " STATE= " + second.getState());
        System.out.println();

        first.start();
        second.start();
        // RUNNABLE - запустился поток, метод start()
        System.out.println("main:THREAD= " + first.getName() + " STATE= " + first.getState());
        System.out.println("main:THREAD= " + second.getName() + " STATE= " + second.getState());

        while (first.getState() != Thread.State.TERMINATED){
            System.out.println("while:THREAD= " + first + " STATE= " + first.getState());
        }
        while (second.getState() != Thread.State.TERMINATED){
            System.out.println("while:THREAD= " + second + " STATE= " + second.getState());
        }


        //TERMINATED когда метод run() завершился
        System.out.println();
        System.out.println("TERMINATED THREAD= " + first.getName());
        System.out.println("TERMINATED THREAD= " + second.getName());
        System.out.println("endTHREAD= " + Thread.currentThread().getName() + " STATE= " + Thread.currentThread().getState());
    }
}
