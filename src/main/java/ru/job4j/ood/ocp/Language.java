package ru.job4j.ood.ocp;

import java.util.ArrayList;
import java.util.List;

public class Language {
    //В данном класссе нарушается в поле класса, поле относится только к одному языку,
    // лучше сделать его абстрактным например Language language;
    private English english;

    // возращаемые значение тоже должны быть абстрактными
    public English getEnglish() {
        return english;
    }

    public void setEnglish(English english) {
        this.english = english;
    }

    // так же обьект не должен создаваться в методе, лучше вынести в перемнную
    public List<English> write() {
        List<English> rsl = new ArrayList<>();
        return rsl;
    }

}
