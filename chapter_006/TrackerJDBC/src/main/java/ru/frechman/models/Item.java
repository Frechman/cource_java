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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Item item = (Item) o;

        if (createDate != item.createDate) {
            return false;
        }
        if (id != null ? !id.equals(item.id) : item.id != null) {
            return false;
        }
        if (name != null ? !name.equals(item.name) : item.name != null) {
            return false;
        }
        return description != null ? description.equals(item.description) : item.description == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (createDate ^ (createDate >>> 32));
        return result;
    }
}