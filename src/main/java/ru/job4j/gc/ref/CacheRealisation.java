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
    private String paths;

    public CacheRealisation(String paths) {
        this.paths = paths;
    }

    private String readfile(String fileName) {
        String tmp = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(paths + fileName))) {
            tmp = bufferedReader.lines().collect(Collectors.joining(" "));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tmp;
    }

    public String getHash(String fileName) {
        String strong = "";
        if (cache.containsKey(fileName)) {
            strong = cache.get(fileName).get();
        } else {
            strong = readfile(fileName);
            cache.put(fileName, new SoftReference<>(strong));
        }
        return strong;
    }

    public static void main(String[] args) {
        CacheRealisation cr = new CacheRealisation("./db/");
        System.out.println(cr.getHash("Address.txt"));
        System.out.println(cr.getHash("Names.txt"));
        System.out.println(cr.getHash("Address.txt"));
        for (Map.Entry<String, SoftReference<String>> pair : cr.cache.entrySet()) {
            String key = pair.getKey();
            SoftReference<String> value = pair.getValue();
            System.out.println(key + " : " + System.lineSeparator() + value.get());
        }
    }
}
