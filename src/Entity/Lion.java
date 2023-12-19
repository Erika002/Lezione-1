package Entity;

import Interface.IAnimalWithTail;

import java.time.LocalDate;

public class Lion extends Animal implements IAnimalWithTail {
    private double tailLength;


    public Lion(String species, String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double tailLength) {
        super(species, name, favoriteFood, age, entryDate, weight, height);
        this.tailLength = tailLength;
    }

    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double tailLength) {
        this.tailLength = tailLength;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + getSpecies() + '\'' +
                ", name='" + getName() + '\'' +
                ", favorite food='" + getFavoriteFood() + '\'' +
                ", age=" + getAge() +
                ", entry date=" + getEntryDate() +
                ", weight=" + getWeight() +
                ", height=" + getHeight() +
                ", tail length=" + tailLength +
                '}';
    }

    @Override
    public boolean hasTail() {
        return true;
    }
}
