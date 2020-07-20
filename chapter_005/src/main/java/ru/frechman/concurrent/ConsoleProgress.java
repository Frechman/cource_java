package ru.frechman.concurrent;

public class ConsoleProgress implements Runnable {
    @Override
    public void run() {
        String[] symbols = {"—", "\\", "|", "/"};
        int i = 0;
        while (!Thread.currentThread().isInterrupted()) {
            String symbol = symbols[i++];
            System.out.print("\rLoad : " + symbol);

            try {
                Thread.sleep(300L);
            } catch (InterruptedException e) {
                System.out.println(System.lineSeparator() + "Из другого потока прервали данный поток");
                return;
            }

            if (i == 4) {
                i = 0;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread progress = new Thread(new ConsoleProgress());
        progress.start();
        Thread.sleep(10000); // симулируем выполнение параллельной задачи в течение 10 секунды
        progress.interrupt(); // Сигнал потоку, чтобы он прервался
    }
}
