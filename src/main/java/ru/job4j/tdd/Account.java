package ru.job4j.tdd;

import java.util.List;
import java.util.function.Predicate;

public interface Account {

    List<Ticket> tikkets();

    boolean add(Ticket ticket);

    boolean remove(Ticket ticket);
}
