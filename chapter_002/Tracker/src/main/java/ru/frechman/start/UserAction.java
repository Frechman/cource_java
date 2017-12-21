package ru.frechman.start;

public interface UserAction {

    /**
     * Item Menu.
     * @return number Item Menu.
     */
    int key();

    /**
     * Выполняет действия пользователя.
     * @param input Ввод от пользователя.
     * @param tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Что пользователь делает.
     * @return Строку - действие пользователя.
     */
    String info();
}
