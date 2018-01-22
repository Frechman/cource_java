package task;

public class CoffeeMachine {

    /**
     * в автомате монеты наминалом 1 2 5 10 Пример. Мы засунули 50 рублей выбрали кофе за 35. Сдачу
     * автомат должен дать 15 рублей Алгоритм должен вернуть наименьшее количество монет. Метод
     * вернет массив {10, 5} = 15 рублей
     *
     * @param value купюра 50,100...
     * @param price цена коффе
     */
    public int[] changes(int value, int price) {
        int change = price - value;
        int[] result = new int[change];

        for (int i = 0; i < result.length; i++) {
            if (change % 10 == 0) {
                result[i] = change % 10;
            }
        }

        return result;
    }
}
