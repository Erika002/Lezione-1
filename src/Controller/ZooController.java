package Controller;
import Entity.Animal;
import Entity.Eagle;
import Entity.Leon;
import Entity.Tiger;


import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ZooController {
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    LeonController leonController = LeonController.getInstance();
    TigerController tigerController = TigerController.getInstance();
    EagleController eagleController = EagleController.getInstance();
    private List<Animal> animals;

    public ZooController() {
        this.animals = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimals(Animal animal) {
        animals.add(animal);
    }
    private List<Animal> getAnimalsBySpecies(String species) {
        List<Animal> animalSpecies = new ArrayList<>();

        for (Animal animal : animals) {
            if (animal.getSpecies().equalsIgnoreCase(species)) {
                animalSpecies.add(animal);
            }
        }
        return animalSpecies;
    }

    public void insertAnimal(Scanner scanner, String species) throws ParseException {
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

        Animal newAnimal = null;
        switch (species.toLowerCase()) {
            case "leon":
                System.out.print("Length thing: ");
                double lionTailLength = scanner.nextDouble();
                scanner.nextLine();
                newAnimal = new Leon(species, name, favoriteFood, age, entryDate, weight, height, lionTailLength);
                Leon nuovoLeon = new Leon(species, name, favoriteFood, age, entryDate, weight, height, lionTailLength);
                leonController.addLeons(nuovoLeon);
                break;
            case "tiger":
                System.out.print("Length thing: ");
                double tigerTailLength = scanner.nextDouble();
                scanner.nextDouble();
                newAnimal = new Tiger(species, name, favoriteFood, age, entryDate, weight, height, tigerTailLength);
                Tiger nuovaTiger = new Tiger(species, name, favoriteFood, age, entryDate, weight, height, tigerTailLength);
                tigerController.addTigers(nuovaTiger);
                break;
            case "eagle":
                System.out.print("Wing width: ");
                double eagleWingWidth = scanner.nextDouble();
                scanner.nextDouble();
                newAnimal = new Eagle(species, name, favoriteFood, age, entryDate, weight, height, eagleWingWidth);
                Eagle nuovaEagle = new Eagle(species, name, favoriteFood, age, entryDate, weight, height, eagleWingWidth);
                eagleController.addEagle(nuovaEagle);
                break;
            default:
                System.out.println("Species not supported.");
                return;
        }

        addAnimals(newAnimal);
    }

    public void findTallerSpecimen(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal specimentTallest = animalSpecies.stream()
                .max(Comparator.comparingDouble(Animal::getHeight))
                .orElse(null);

        System.out.println("the " + species + "tallest is" + specimentTallest.getName() +
                " with height " + specimentTallest.getHeight() + "cm");
    }

    public void findLowerSpecimen(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal specimentLower = animalSpecies.stream()
                .min(Comparator.comparingDouble(Animal::getHeight))
                .orElse(null);

        System.out.println("The " + species + " lower is" + specimentLower.getName() +
                "  with height " + specimentLower.getHeight() + "cm");
    }

    public void findHeavierSpecimen(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal specimentHeavier = animalSpecies.stream()
                .max(Comparator.comparingDouble(Animal::getWeight))
                .orElse(null);

        System.out.println("The " + species + " heavier is " + specimentHeavier.getName() +
                " with weight" + specimentHeavier.getWeight() + "kg");
    }

    public void findLighterSpecimen(String species) {
        List<Animal> animalSpecies = getAnimalsBySpecies(species);

        if (animalSpecies.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal specimentLighter = animalSpecies.stream()
                .min(Comparator.comparingDouble(Animal::getWeight))
                .orElse(null);

        System.out.println("Il " + species + " lighter is " + specimentLighter.getName() +
                " with weight " + specimentLighter.getWeight() + "kg");
    }





}
