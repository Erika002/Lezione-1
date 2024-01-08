package entity;

import java.time.LocalDate;

public abstract class AnimalWithTail extends Animal {
    public AnimalWithTail(String species, String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height) {
        super(species, name, favoriteFood, age, entryDate, weight, height);
    }

    public abstract double getTailLength();
    public abstract void setTailLength(double tailLength);
}
