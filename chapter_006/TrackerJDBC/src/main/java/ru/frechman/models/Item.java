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
    private long create;

    /**
     * Item's category.
     */
    private int category;

    /**
     * Item's state.
     */
    private int state;

    /**
     * Comments item.
     */
    private String[] comments;

    public Item(String name, String description, long create, int category, int state) {
        this.name = name;
        this.description = description;
        this.create = create;
        this.category = category;
        this.state = state;
    }

    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public int getCategory() {
        return category;
    }

    public int getState() {
        return state;
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

    public long getCreate() {
        return create;
    }

    public String[] getComments() {
        return comments;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreate(long create) {
        this.create = create;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}