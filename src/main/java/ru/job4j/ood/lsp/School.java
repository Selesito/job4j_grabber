package ru.job4j.ood.lsp;

public class School {
    private int score;
    private int stipend;

    public School(int score, int stipend) {
        this.score = score;
        this.stipend = stipend;
    }

    public int getStipend() {
        return stipend;
    }

    public void calculation(int stipend) {
        if (score > 4) {
            if (stipend > this.stipend) {
                throw new IllegalArgumentException();
            } else {
                System.out.println("learn student");
            }
        }

    }
}

class Student extends School {

    protected Student(int score, int stipend) {
        super(score, stipend);
    }

    public void calculation(int stipend) {
        //Тут нарушено постусловие, а точнее ослабленны...
        if (stipend > getStipend() + 7800) {
            // услили предусловие в наследованом классе
            throw new IllegalArgumentException();
        } else {
            System.out.println("learn student");
        }
    }
}
