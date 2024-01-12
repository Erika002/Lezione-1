package entity;

import Interface.SpeciesInfo;

import java.time.LocalDate;

@SpeciesInfo(name = "HORSE")
public class Horse extends AnimalWithTail{
    public Horse(String species, String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height) {
        super(species, name, favoriteFood, age, entryDate, weight, height);
    }

    @Override
    public double getTailLength() {
        return 0;
    }

    @Override
    public void setTailLength(double tailLength) {

    }
}
