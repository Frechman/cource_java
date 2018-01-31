package task;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private final static int[] COINS = {100, 50, 10, 5, 2, 1};

    /**
     * в автомате монеты наминалом 1 2 5 10 Пример. Мы засунули 50 рублей выбрали кофе за 35. Сдачу
     * автомат должен дать 15 рублей Алгоритм должен вернуть наименьшее количество монет. Метод
     * вернет массив {10, 5} = 15 рублей
     *
     * @param value banknote.
     * @param price price of coffee.
     * @return change.
     */
    public List<Integer> change(int value, int price) {
        int amount = value - price;
        List<Integer> change = new ArrayList<>();

        for (int i = 0; i < COINS.length; i++) {
            while (amount >= COINS[i]) {
                change.add(COINS[i]);
                amount -= COINS[i];
            }
        }

        return change;
        /*int[] result = new int[change.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = change.get(i);
        }
        return result;*/

        //return change.stream().mapToInt(i-> i).toArray();
    }
}
