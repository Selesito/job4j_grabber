package ru.job4j.ood.ocp;

public class Constructor {

    private static class Car {
        //Нарушение в методе так отстувует абстракция, так машины бывают разные,
        // а мест получается у всех одинаково
        public int seats() {
            return 4;
        }
    }
}
