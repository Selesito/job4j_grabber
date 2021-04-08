package ru.job4j.tdd;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AccountTest {

    @Test
    public void add() {
        Account account = new AccountCinema();
        Ticket ticket = new Ticket3D();
        assertTrue(account.add(ticket));
    }

    @Test
    public void remove() {
        Account account = new AccountCinema();
        Ticket ticket = new Ticket3D();
        assertTrue(account.remove(ticket));
    }

    @Test
    public void tikkets() {
        Account account = new AccountCinema();
        Ticket ticket = new Ticket3D();
        Ticket ticket1 = new Ticket3D();
        account.add(ticket);
        account.add(ticket1);
        account.remove(ticket1);
        List<Ticket> rsl = account.tikkets();
        assertThat(rsl, is(ticket));
    }
}