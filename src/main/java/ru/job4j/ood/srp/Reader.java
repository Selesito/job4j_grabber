package ru.job4j.ood.srp;

import java.util.List;

public interface Reader<T> {
    List<T> reader(String file);

    void write(List<T> str);

    void print(String str);
}
