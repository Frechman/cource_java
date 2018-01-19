package ru.frechman.start;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import ru.frechman.models.Item;

/**
 * The class implements a tracking system.
 */
public class Tracker {

    /**
     * Random generate for ID number.
     */
    private static final Random RN = new Random();

    /**
     * List for save items.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * Add item to array.
     *
     * @param item New item.
     * @return this item.
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Edit item.
     *
     * @param id Id edit item.
     * @param item New edited item.
     */
    public void edit(String id, Item item) {
        for (Item current : items) {
            if (current != null) {
                if (current.getId().equals(id)) {
                    item.setId(current.getId());
                    items.set(items.indexOf(current), item);
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
        items.removeIf(a -> Objects.equals(a.getId(), id));
        /*for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
                if (this.items[i].getId().equals(id)) {
                    //искодный массив, с позиции srcPos, копируется в новый массив(или этотже) начиная
                    //с позиции destPos, length - кол-во элементов которые надо скопировать
                    System.arraycopy(this.items, i + 1, this.items, i, (this.items.length - 1) - i);
                }
            }
        }*/
    }

    /**
     * Find all item.
     *
     * @return Copy List of Items without null-elements.
     */
    public List<Item> findAll() {
        List<Item> resultArrItems = new ArrayList<>();
        for (Item originItem : this.items) {
            if (originItem != null) {
                resultArrItems.add(originItem);
            }
        }
        return resultArrItems;
    }

    /**
     * All items.
     *
     * @return List of Items all item.
     */
    public List<Item> getAll() {
        return this.items;
    }

    /**
     * Find item by id.
     *
     * @param id Desired id of item.
     * @return Found item.
     */
    public Item findById(String id) {
        Item foundItem = null;
        for (Item item : this.items) {
            if (item != null) {
                if (item.getId().equals(id)) {
                    foundItem = item;
                    break;
                }
            }
        }
        return foundItem;
    }

    /**
     * Find item by item's name.
     *
     * @param key Desired name of item.
     * @return List of Items found items.
     */
    public List<Item> findByName(String key) {
        List<Item> resultArrItems = new ArrayList<>();
        for (Item originItem : this.items) {
            if (originItem != null) {
                if (originItem.getName().equals(key)) {
                    resultArrItems.add(originItem);
                }
            }
        }
        return resultArrItems;
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




