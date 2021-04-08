package ru.job4j.tdd;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicketTest {

    @Test
    public void getSession() {
        Ticket ticket = new Ticket3D();
        assertNull(ticket.getSession());
    }

    @Test
    public void getData() {
        Ticket ticket = new Ticket3D();
        assertNull(ticket.getData());
    }
}