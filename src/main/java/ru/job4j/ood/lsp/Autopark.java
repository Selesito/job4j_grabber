package ru.job4j.ood.lsp;

public class Autopark {
    private boolean fuel;
    private boolean clear;

    public Autopark(boolean fuel, boolean clear) {
        this.fuel = fuel;
        this.clear = clear;
    }

    public boolean isFuel() {
        return fuel;
    }

    public boolean isClear() {
        return clear;
    }
}

class Sto {

    private Autopark autopark;

    public Sto(Autopark autopark) {
        valid();
        this.autopark = autopark;
    }

    protected void  valid() {
    }

    public Autopark getAutopark() {
        return autopark;
    }

    public void setServiceability(Autopark autopark) {
        valid();
        this.autopark = autopark;
    }
}

class Transport extends Sto {

    public Transport(Autopark autopark) {
        super(autopark);
    }
    //Нарушение все условия базового класса - также должны быть сохранены и в подклассе

    public void setServiceability(Autopark autopark) {
        setServiceability(autopark);
    }
}

