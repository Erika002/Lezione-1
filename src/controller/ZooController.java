package controller;
import Interface.IAnimalWithTail;
import Interface.IAnimalWithWings;
import entity.Animal;
import entity.Eagle;
import entity.Lion;
import entity.Tiger;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ZooController {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    private final List<Animal> animals;


    public ZooController() {
        this.animals = new ArrayList<>();

    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public List<Animal> getAnimalsBySpecies(String species) {
        List<Animal> animalSpecies = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.getSpecies().equalsIgnoreCase(species)) {
                animalSpecies.add(animal);
            }
        }
        return animalSpecies;
    }

    public void insertAnimal(Scanner scanner, String species) {
        System.out.println("Enter the details of the new one " + species + ":");

        System.out.print("name: ");
        String name = scanner.nextLine();

        System.out.print("Favorite food: ");
        String favoriteFood = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();

        System.out.print("Weight: ");
        double weight = scanner.nextDouble();

        System.out.print("Height: ");
        double height = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Date of entry into the zoo (format dd-MM-yyyy): ");
        String date = scanner.nextLine();
        System.out.println(date + "date");
        LocalDate entryDate = LocalDate.parse(date, dateFormatter);

        switch (species.toLowerCase()) {
            case "lion":
                System.out.print("Length thing: ");
                double lionTailLength = scanner.nextDouble();
                scanner.nextLine();
                Lion newLion = new Lion(species, name, favoriteFood, age, entryDate, weight, height, lionTailLength);
                addAnimal(newLion);
                break;
            case "tiger":
                System.out.print("Length thing: ");
                double tigerTailLength = scanner.nextDouble();
                scanner.nextLine();
                Tiger newTiger = new Tiger(species, name, favoriteFood, age, entryDate, weight, height, tigerTailLength);
                addAnimal(newTiger);

                break;
            case "eagle":
                System.out.print("Wing width: ");
                double eagleWingWidth = scanner.nextDouble();
                scanner.nextLine();
                Eagle newEagle = new Eagle(species, name, favoriteFood, age, entryDate, weight, height, eagleWingWidth);
                addAnimal(newEagle);
                break;
            default:
                System.out.println("Unrecognized species. Please enter a valid species.");
        }
    }

    public void findTallerSpecimen(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo .");
        }
        Animal specimenTallest = animalSpecies.stream()
                .max(Comparator.comparingDouble(Animal::getHeight))
                .orElse(null);

        assert specimenTallest != null;
        System.out.println("the " + species + " tallest is " + specimenTallest.getName() +
                " with height " + specimenTallest.getHeight() + "cm");
    }

    public void findLowerSpecimen(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo, now.");
            return;
        }

        Animal specimenLower = animalSpecies.stream()
                .min(Comparator.comparingDouble(Animal::getHeight))
                .orElse(null);

        System.out.println("The " + species + " lower is " + specimenLower.getName() +
                "  with height " + specimenLower.getHeight() + " cm");
    }

    public void findHeavierSpecimen(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal specimenHeavier = animalSpecies.stream()
                .max(Comparator.comparingDouble(Animal::getWeight))
                .orElse(null);

        System.out.println("The " + species + " heavier is " + specimenHeavier.getName() +
                " with weight " + specimenHeavier.getWeight() + " kg");
    }

    public void findLighterSpecimen(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal specimenLighter = animalSpecies.stream()
                .min(Comparator.comparingDouble(Animal::getWeight))
                .orElse(null);

        System.out.println("Il " + species + " lighter is " + specimenLighter.getName() +
                " with weight " + specimenLighter.getWeight() + " kg");
    }

    public void findLongestTailOfASpecies(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal longestTailAnimal = (Animal) animalSpecies.stream()
                .filter(IAnimalWithTail.class::isInstance)
                .map(IAnimalWithTail.class::cast)
                .max(Comparator.comparingDouble(IAnimalWithTail::getTailLength))
                .orElse(null);

        if (longestTailAnimal != null) {
            System.out.println("The " + species + " with the longest tail is: " +
                    longestTailAnimal.getName() + " with measure " +
                    ((IAnimalWithTail) longestTailAnimal).getTailLength() + " cm");
        } else {
            System.out.println("No " + species + " with a tail present in the zoo.");
        }
    }

    public void findWidestWingWidthOfASpecies(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal widestWingWidthAnimal = (Animal) animalSpecies.stream()
                .filter(IAnimalWithWings.class::isInstance)
                .map(IAnimalWithWings.class::cast)
                .max(Comparator.comparingDouble(IAnimalWithWings::getWingWidth))
                .orElse(null);

        if (widestWingWidthAnimal != null) {
            System.out.println("The " + species + " with the widest wingspan is: " +
                    widestWingWidthAnimal.getName() + " with measure " +
                    ((IAnimalWithWings) widestWingWidthAnimal).getWingWidth() + " cm");
        } else {
            System.out.println("No " + species + " with wings present in the zoo.");
        }
    }

    public void findLongestTailAcrossAllSpecies() {
        List<Animal> animalsWithTail = getAnimals().stream()
                .filter(IAnimalWithTail.class::isInstance)
                .toList();

        if (animalsWithTail.isEmpty()) {
            System.out.println("No animals with tail present in the zoo.");
            return;
        }

        Animal longestTailAnimal = (Animal) animalsWithTail.stream()
                .map(IAnimalWithTail.class::cast)
                .max(Comparator.comparingDouble(IAnimalWithTail::getTailLength))
                .orElse(null);

            System.out.println("The animal with the longest tail is: " +
                    longestTailAnimal.getName() + " of species " + longestTailAnimal.getSpecies() +
                    " with measure " + ((IAnimalWithTail) longestTailAnimal).getTailLength() + " cm");

    }

    public void findWidestWingWidthAcrossAllSpecies() {
        List<Animal> animalsWithWings = getAnimals().stream()
                .filter(IAnimalWithWings.class::isInstance)
                .toList();

        if (animalsWithWings.isEmpty()) {
            System.out.println("No animals with wings present in the zoo.");
            return;
        }

        Animal widestWingWidthAnimal = (Animal) animalsWithWings.stream()
                .map(IAnimalWithWings.class::cast)
                .max(Comparator.comparingDouble(IAnimalWithWings::getWingWidth))
                .orElse(null);

            System.out.println("The animal with the widest wingspan is: " +
                    widestWingWidthAnimal.getName() + " of species " + widestWingWidthAnimal.getSpecies() +
                    " with measure " + ((IAnimalWithWings) widestWingWidthAnimal).getWingWidth() + " cm");
    }







}
