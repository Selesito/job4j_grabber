package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorNSTest {

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void produce3() {
        Generator generator = new GeneratorNS();
        String rsl = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "Ivan");
        args.put("surname", "Arsentev");
        generator.produce(rsl, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void produce2() {
        Generator generator = new GeneratorNS();
        String rsl = "I am a ${name} ${surname}, Who are ${subject}? ";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "Ivan");
        generator.produce(rsl, args);
    }
}