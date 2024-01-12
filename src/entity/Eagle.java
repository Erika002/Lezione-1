package entity;

import Interface.SpeciesInfo;

import java.time.LocalDate;
@SpeciesInfo(name = "EAGLE")
public class Eagle extends AnimalWithWings {
    private double wingWidth;


    public Eagle(String species, String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingWidth) {
        super(species, name, favoriteFood, age, entryDate, weight, height);
        this.wingWidth = wingWidth;
    }

    @Override
    public double getWingWidth() {
        return wingWidth;
    }

    @Override
    public void setWingWidth(double wingWidth) {
        this.wingWidth = wingWidth;
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
                ", wing width=" + wingWidth +
                '}';
    }


}
