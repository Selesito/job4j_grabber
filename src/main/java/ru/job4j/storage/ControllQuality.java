package ru.job4j.storage;

import java.util.ArrayList;
import java.util.List;

public class ControllQuality {
    private List<Storage> storages;

    public ControllQuality(List<Storage> storages) {
        this.storages = storages;
    }

    public void productDistributor(List<Food> foods) {
        for (Food food : foods) {
            for (Storage storage : storages) {
                storage.add(food);
            }
        }
    }

    public void resort() {
        List<Food> foods = new ArrayList<>();
        for (Storage storage : storages) {
            for (Food food : storage.getFood()) {
                foods.add(food);
            }
            storage.clear();
        }
        productDistributor(foods);
    }
}
