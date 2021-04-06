package ru.job4j.gc.ref;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CacheRealisation {
    private final Map<String, SoftReference<String>> cache = new HashMap<>();

    public String readfile(String fileName) {
        String tmp = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            tmp = bufferedReader.lines().collect(Collectors.joining(" "));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public void getHash(String fileName) {
        String strong = "";
        if (cache.containsKey(fileName)) {
            System.out.println("Этот файл уже в кэше: " + fileName);
        } else {
            strong = readfile(fileName);
            cache.put(fileName, new SoftReference<>(strong));
        }
    }

    public static void main(String[] args) {
        CacheRealisation cr = new CacheRealisation();
        cr.getHash("db/Address.txt");
        cr.getHash("db/Names.txt");
        cr.getHash("db/Address.txt");
        for (Map.Entry<String, SoftReference<String>> pair : cr.cache.entrySet()) {
            String key = pair.getKey();
            SoftReference<String> value = pair.getValue();
            System.out.println(key + " : " + System.lineSeparator() + value.get());
        }
    }
}
