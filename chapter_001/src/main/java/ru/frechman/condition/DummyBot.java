package ru.frechman.condition;

/**
 * Implement a Dummy Bot.
 */
public class DummyBot {

    /**
     * Answers the questions.
     *
     * @param question clients.
     * @return bot's answer.
     */
    public String answer(String question) {
        String answer = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот!".equals(question)) {
            answer = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            answer = "До скорой встречи.";
        }
        return answer;
    }
}