package ru.job4j.ood.dip;

public class Auto {
//    Вот так же нарушение, можно создать интерфейс и чтобы класс работал через него,
//    и так сказать автомобили могли пользваться заправками в зависимости от его реализации
    private Lukoil lukoil;

    public Auto(Lukoil lukoil) {
        this.lukoil = lukoil;
    }
}
