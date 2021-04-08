package ru.job4j.tdd;

import java.util.List;

public class AccountCinema implements Account {
    @Override
    public List<Ticket> tikkets() {
        return null;
    }

    @Override
    public boolean add(Ticket ticket) {
        return false;
    }

    @Override
    public boolean remove(Ticket ticket) {
        return false;
    }
}
