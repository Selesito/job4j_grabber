package ru.job4j.menu;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;
    private Action action = new ClickAction();
    private List<Item> listItems = new ArrayList();

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getListItems() {
        return listItems;
    }

    public void setListItems(Item item) {
        this.listItems.add(item);
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
