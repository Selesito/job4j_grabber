package ru.job4j.ood.isp;

public class Car implements PowerCalc {
// нарушение isp заключается в том, что машина реализует интерфейс который расчитывает
// запас хода на все машины, на различные двигатели! Лучше сделать отдельные интерфейсы)
    @Override
    public int calcCurrent() {
        return 0;
    }

    @Override
    public int caclGas() {
        return 0;
    }

    @Override
    public int calcDisel() {
        return 0;
    }
}
