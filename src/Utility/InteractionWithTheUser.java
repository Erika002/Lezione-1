package Utility;

import entity.Animal;
import entity.AnimalWithTail;
import entity.AnimalWithWings;

import java.util.Scanner;

public class InteractionWithTheUser {

    public InteractionWithTheUser() {}

    Scanner scanner = new Scanner(System.in);

    public void printMessage(Main.Species species){
        System.out.println("Enter the details of the new " + species + ":");
    }
    public void printMessageDefault(){
        System.out.println("Unrecognized species. Please enter a valid species.");
    }
    public String insertString(String message) {
        System.out.print(message+ ": ");
        return scanner.nextLine();
    }

    public int insertInt(String message){
        System.out.print(message+ ": ");
        return scanner.nextInt();
    }

    public double insertDouble(String message){
        System.out.print(message+ ": ");
        return scanner.nextDouble();
    }

    public void printMessageSpeciesNotFound(Main.Species species){
        System.out.println("No " + species + " present in the zoo.");

    }

    public void messageFindTallerSpecimen(Main.Species species, Animal specimenTallest){
        System.out.println("The " + species + " tallest is " + specimenTallest.getName() +
                " with height " + specimenTallest.getHeight() + "cm");
    }
    public void messageFindLowerSpecimen(Main.Species species, Animal specimenLower){
        System.out.println("The " + species + " lower is " + specimenLower.getName() +
                " with height " + specimenLower.getHeight() + "cm");
    }
    public void messageFindHeavierSpecimen(Main.Species species, Animal specimenHeavier){
        System.out.println("The " + species + " heavier is " + specimenHeavier.getName() +
                " with weight " + specimenHeavier.getWeight() + "kg");
    }
    public void messageFindLighterSpecimen(Main.Species species, Animal specimenLighter){
        System.out.println("The " + species + " lighter is " + specimenLighter.getName() +
                " with weight " + specimenLighter.getWeight() + "kg");
    }
    public void messageFindLongestTailOfASpecies(Main.Species species, Animal longestTailAnimal){
        if(longestTailAnimal != null){
            System.out.println("The " + species + " with the longest tail is: " +
                    longestTailAnimal.getName() + " with measure " +
                    ((AnimalWithTail) longestTailAnimal).getTailLength() + " cm");
        } else {
            System.out.println("No " + species + " with a tail present in the zoo.");
        }
    }
    public void messageFindWidestWingWidthOfASpecies(Main.Species species, Animal widestWingWidthAnimal){
        if(widestWingWidthAnimal != null){
            System.out.println("The " + species + " with the widest wingspan is: " +
                    widestWingWidthAnimal.getName() + " with measure " +
                    ((AnimalWithWings) widestWingWidthAnimal).getWingWidth() + " cm");
        } else {
            System.out.println("No " + species + " with wings present in the zoo.");
        }
    }
    public void messageNoAnimalsWithWing() {
        System.out.println("No animals with wings present in the zoo.");
    }
    public void messageAllAnimalsWithWing(AnimalWithWings widestWingWidthAnimal){
        System.out.println("The animal with the widest wingspan is: " +
                widestWingWidthAnimal.getName() + " of species " + widestWingWidthAnimal.getSpecies() +
                " with measure " + widestWingWidthAnimal.getWingWidth() + " cm");
    }
    public void messageNoAnimalsWithTail() {
        System.out.println("No animals with tail present in the zoo.");
    }

    public void messageAllAnimalsWithTail(AnimalWithTail longestTailAnimal){
        System.out.println("The animal with the longest tail is: " +
                longestTailAnimal.getName() + " of species " + longestTailAnimal.getSpecies() +
                " with measure " + longestTailAnimal.getTailLength() + " cm");
    }
    public void insertAnimal(){
        System.out.println("Choose the new animal to insert:");
        System.out.println("1. Lion");
        System.out.println("2. Tiger");
        System.out.println("3. Eagle");
    }
    public void insertAnimalFor() {
        System.out.println("Choose the new animal to insert:");

        Main.Species[] speciesValues = Main.Species.values();

        for (int i = 0; i < speciesValues.length; i++) {
            System.out.println((i + 1) + ". " + speciesValues[i]);
        }
    }


    public void messageInsert() {
        System.out.println("To insert a new animal, type '+'. Otherwise, type '-':");
    }

    public void chooseAnimal() {
        System.out.println("Choose a species for your search:");
        System.out.println("1. Lion");
        System.out.println("2. Tiger");
        System.out.println("3. Eagle");
    }

    public void invalidChoice(){
        System.out.println("Invalid choice.");
    }

    public void chooseAnOption(Main.Species selectedSpecies ){
        System.out.println("Choose an option:");
        System.out.println("1. Find the tallest specimen among " + selectedSpecies);
        System.out.println("2. Find the lowest specimen among " + selectedSpecies);
        System.out.println("3. Find the heaviest specimen among " + selectedSpecies);
        System.out.println("4. Find the lightest specimen among " + selectedSpecies);
        if (selectedSpecies == Main.Species.LION || selectedSpecies == Main.Species.TIGER) {
            System.out.println("5. Find the specimen with the longest tail");
        } else {
            System.out.println("5. Find the specimen with the largest wingspan");
        }
        System.out.println("6. Find the animal with the longest tail");
        System.out.println("7. Find the animal with the widest wingspan");
        System.out.println("0. Exit");
    }

    public void exit(){
        System.out.println("Exiting the program.");
    }
    public void errorMessage(String speciesName){
        System.out.println("Species not found: " + speciesName + ". Add it to the enum list.");
    }


}
