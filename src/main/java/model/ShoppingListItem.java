package model;

public class ShoppingListItem {

    private int id;
    private String title;

    public ShoppingListItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public ShoppingListItem(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof ShoppingListItem && ((ShoppingListItem) other).id == this.id;
    }
}