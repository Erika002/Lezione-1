package entity;
import java.time.LocalDate;
public abstract class Animal {
   private String species;
   private String name;
   private String favoriteFood;
   private int age;
   private LocalDate entryDate;
   private double weight;
   private double height;

    public Animal(String species, String name, String favoriteFood, int age, LocalDate entryDate, double weight, double height) {
       this.species = species;
       this.name = name;
       this.favoriteFood = favoriteFood;
       this.age = age;
       this.entryDate = entryDate;
       this.weight = weight;
       this.height = height;
    }

   public String getSpecies() {
      return species;
   }

   public void setSpecies(String species) {
      this.species = species;
   }

   public String getName() {
      return name;
   }

   public void setName(String nome) {
      this.name = nome;
   }

   public String getFavoriteFood() {
      return favoriteFood;
   }

   public void setFavoriteFood(String favoriteFood) {
      this.favoriteFood = favoriteFood;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public LocalDate getEntryDate() {
      return entryDate;
   }
   public void setEntryDate(LocalDate entryDate) {
      this.entryDate = entryDate;
   }
   public double getWeight() {
      return weight;
   }
   public void setWeight(double weight) {
      this.weight = weight;
   }
   public double getHeight() {
      return height;
   }
   public void setHeight(double height) {
      this.height = height;
   }

}
