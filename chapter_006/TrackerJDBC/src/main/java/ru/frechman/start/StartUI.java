package ru.frechman.start;

import java.io.File;

public class StartUI {

    /**
     * Константа для выхода из программы.
     */
    private static final int EXIT = 7;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Запуск программы.
     *
     * @param args Args command line.
     */
    public static void main(String[] args) throws Exception {
        File file = new File(args[0]);
        try (Tracker tracker = new Tracker(file)) {
            new StartUI(new ValidateInput(new ConsoleInput()), tracker).init();
        }
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        boolean exit = false;
        while (!exit) {
            menu.showMenu();
            int userChoice = this.input
                    .ask("Введите пункт меню : ", new int[]{1, 2, 3, 4, 5, 6, 7});
            menu.select(userChoice);
            if (userChoice == EXIT) {
                exit = true;
            }
        }
    }
}