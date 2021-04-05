package ru.job4j.gc;

import static com.carrotsearch.sizeof.RamUsageEstimator.sizeOf;

public class User {
    private String name;
    private String surname;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.printf("Removed %s %s %d%n", name, surname, age);
    }

    public static void main(String[] args) {
        User user = new User("A", "B", 23);
        System.out.printf("size of user = %d\n", sizeOf(user));
        GCDemo.info();
        for (int i = 0; i < 17476; i++) {
            new User("A", "B", i);
        }
        GCDemo.info();
    }
}
