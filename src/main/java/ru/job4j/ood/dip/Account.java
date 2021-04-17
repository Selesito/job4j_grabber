package ru.job4j.ood.dip;

import java.util.ArrayList;
import java.util.List;

public class Account {
//  Правильнее было бы выделить интрефейс с методом, и различные его реализации будут
//  использовать разные коллекции
    private List<User> users = new ArrayList<>();

    public boolean add(User user) {
//   В этом случае зависимость, создается и происходит работа с другим классом
        return users.add(new User());
    }
}
