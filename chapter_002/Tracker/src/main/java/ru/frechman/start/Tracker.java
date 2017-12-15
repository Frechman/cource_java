package ru.frechman.start;

import ru.frechman.models.Item;

import java.util.Arrays;
import java.util.Random;

public class Tracker {

    private static final Random RN = new Random();
    /**
     * Array for save items.
     */
    private Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Add item to array.
     *
     * @param item New item.
     * @return this item.
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Edit item.
     *
     * @param id   Id edit item.
     * @param item New edited item.
     */
    public void replace(String id, Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (items[i] != null) {
                if (this.items[i].getId().equals(id)) {
                    item.setId(this.items[i].getId());
                    this.items[i] = item;
                    break;
                }
            }

        }
    }

    /**
     * Delete item.
     *
     * @param id Id item.
     */
    public void delete(String id) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getId().equals(id)) {
                    //искодный массив, с позиции srcPos, копируется в новый массив(или этотже) начиная
                    //с позиции destPos, length - кол-во элементов которые надо скопировать
                    System.arraycopy(this.items, i + 1, this.items, i, (this.items.length - 1) - i);
                }
            }
        }
    }

    /**
     * Find all item.
     *
     * @return Copy array items without null-elements.
     */
    public Item[] findAll() {
        Item[] resultArrItems = new Item[100];
        int indexResultArrItems = 0;
        for (Item originItem : this.items) {
            if (originItem != null) {
                resultArrItems[indexResultArrItems++] = originItem;
            }
        }
        return Arrays.copyOf(resultArrItems, indexResultArrItems);
    }

    /**
     * All items.
     *
     * @return Array all item.
     */
    public Item[] getAll() {
        return items;
    }

    /**
     * Find item by nameItem.
     *
     * @param key Desired name of item.
     * @return Array items found items.
     */
    public Item[] findByName(String key) {
        Item[] resultArrItems = new Item[100];
        int indexResultArrItems = 0;
        for (Item originItem : this.items) {
            if (originItem != null) {
                if (originItem.getName().equals(key)) {
                    resultArrItems[indexResultArrItems++] = originItem;
                }
            }
        }
        return Arrays.copyOf(resultArrItems, indexResultArrItems);
    }

    /**
     * Find item by id.
     *
     * @param id Desired id of item.
     * @return Found item.
     */
    public Item findById(String id) {
        Item foundItem = null;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getId().equals(id)) {
                    foundItem = this.items[i];
                    break;
                }
            }
        }
        return foundItem;
    }

    /**
     * Generate unique number - ID for new Item.
     *
     * @return unique number represent as the String.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}




