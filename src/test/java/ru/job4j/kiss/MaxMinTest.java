package ru.job4j.kiss;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void whenMaxThen9() {
        MaxMin resultMax = new MaxMin();
        List<Integer> list = List.of(1, 7, 4, 8, 6, 2, 9);
        int max = resultMax.max(list, Integer::compareTo);
        assertEquals(max, 9);
    }

    @Test
    public void whenMinThen1() {
        MaxMin resultMax = new MaxMin();
        List<Integer> list = List.of(1, 7, 4, 8, 6, 2, 9);
        int min = resultMax.min(list, Integer::compareTo);
        assertEquals(min, 1);
    }

    @Test
    public void whenMaxThenA() {
        MaxMin resultMax = new MaxMin();
        List<String> list = List.of("A", "B", "C", "D", "E", "F", "G");
        String max = resultMax.max(list, String::compareTo);
        assertEquals(max, "G");
    }
}