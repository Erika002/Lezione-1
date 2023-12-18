package Entity;

import java.time.LocalDate;

public class Eagle extends Animal {
    private double wingWidth;

    public Eagle() {}

    public Eagle(String species, String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height, double wingWidth) {
        super(species, name, favoriteFood, age, entryDate, weight, height);
        this.wingWidth = wingWidth;
    }

    public double getWingWidth() {
        return wingWidth;
    }

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
