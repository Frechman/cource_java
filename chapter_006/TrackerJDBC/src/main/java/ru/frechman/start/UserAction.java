package ru.frechman.start;

public interface UserAction {

    /**
     * Number Item Menu.
     *
     * @return number Item Menu.
     */
    int key();

    /**
     * Выполняет действия этого пункта меню.
     *
     * @param input   Ввод от пользователя.
     * @param tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Название действия пользователя - пункта меню.
     *
     * @return Строку с названием пункта меню.
     */
    String info();
}
