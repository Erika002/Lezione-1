package entity;

import java.time.LocalDate;

public abstract class AnimalWithWings extends Animal {
    public AnimalWithWings(String species, String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height) {
        super(species, name, favoriteFood, age, entryDate, weight, height);
    }

    public abstract double getWingWidth();
    public abstract void setWingWidth(double wingWidth);
}
