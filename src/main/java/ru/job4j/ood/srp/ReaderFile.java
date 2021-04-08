package ru.job4j.ood.srp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderFile implements Reader<String> {
    @Override
    public List<String> reader(String file) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                rsl.add(line);
                print(line);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public void write(List<String> str) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("Names.txt")
                ))) {
            for (String rsl : str) {
                out.println(rsl);            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }
}
