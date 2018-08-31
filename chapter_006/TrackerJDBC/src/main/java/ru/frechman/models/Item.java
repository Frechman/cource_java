package ru.frechman.models;

public class Item {

    /**
     * Unique number item.
     */
    private String id;

    /**
     * Name item.
     */
    private String name;

    /**
     * Description item.
     */
    private String description;

    /**
     * Date of creation.
     */
    private long createDate;

    /**
     * Comments item.
     */
    private String[] comments;

    public Item(String name, String description, long createDate) {
        this.name = name;
        this.description = description;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getCreateDate() {
        return createDate;
    }

    public String[] getComments() {
        return comments;
    }

    public void setId(String id) {
        this.id = id;
    }
}