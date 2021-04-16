package ru.job4j.menu;

public interface AddMenu {

    void addItem(Item item);

    void addSubItem(String parent, Item item);
}
