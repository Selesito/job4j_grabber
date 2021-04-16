package ru.job4j.menu;

import java.util.List;

public class Menu implements AddMenu, ShowMenu {
    private Item items = new Item("Menu");

    @Override
    public void addItem(Item item) {
        items.setListItems(item);
    }

    @Override
    public void addSubItem(String parent, Item item) {
        Item itemParent = searchParent(items, parent);
        if (itemParent != null) {
            itemParent.setListItems(item);
        }
    }

    private Item searchParent(Item items, String parent) {
        Item result = null;
        List<Item> listItem = items.getListItems();
        if (listItem.size() != 0) {
           for (Item item : listItem) {
               if (item.getName().equals(parent)) {
                   result = item;
               } else if (item.getListItems().size() != 0) {
                   result = searchParent(item, parent);
               }
           }
        }
        return  result;
    }

    @Override
    public String show() {
        StringBuilder builder = new StringBuilder();
        for (Item item : items.getListItems()) {
            builder.append(showSubItems(item, 0));
        }
        return builder.toString();
    }

    private String showSubItems(Item item, int level) {
        StringBuilder builder = new StringBuilder();
        builder.append("----".repeat(level) + item.getName()).append(System.lineSeparator());
        if (item.getListItems().size() > 0) {
            for (Item rsl : item.getListItems()) {
                builder.append(showSubItems(rsl, level + 1));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem(new Item("Задача 1."));
        menu.addItem(new Item("Задача 2."));
        menu.addItem(new Item("Задача 3."));
        menu.addSubItem("Задача 1.", new Item("Задача 1.1"));
        menu.addSubItem("Задача 1.1", new Item("Задача 1.1.1"));
        menu.addSubItem("Задача 1.1", new Item("Задача 1.1.2"));
        menu.addSubItem("Задача 1.", new Item("Задача 1.2"));
        menu.addSubItem("Задача 2.", new Item("Задача 2.1"));

        System.out.println(menu.show());
    }
}