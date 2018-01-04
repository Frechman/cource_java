package ru.frechman.start;

public abstract class BaseAction implements UserAction {

    /**
     * Number item menu.
     */
    private final int key;

    /**
     * Name item menu.
     */
    private final String name;

    public BaseAction(final int key, final String name) {
        this.key = key;
        this.name = name;
    }

    @Override
    public int key() {
        return this.key;
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }

}
