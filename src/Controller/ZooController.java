package Controller;
import Entity.Animal;
import Entity.Eagle;
import Entity.Lion;
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

    private List<Eagle> eagles;
    private List<Lion> lions;
    private List<Tiger> tigers;
    private List<Animal> animals;


    public ZooController() {
        this.animals = new ArrayList<>();
        this.eagles = new ArrayList<>();
        this.lions = new ArrayList<>();
        this.tigers = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
    }
    public List<Eagle> getEagles() {
        return eagles;
    }
    public List<Tiger> getTigers() {
        return tigers;
    }
    public List<Lion> getLions() {
        return lions;
    }
    public void addEagle(Eagle eagle) {
        eagles.add(eagle);
    }
    public void addTiger(Tiger tiger) {
        tigers.add(tiger);
    }
    public void addLion(Lion lion) {
        lions.add(lion);
    }





    public void addAnimals(Animal animal) {
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

        switch (species.toLowerCase()) {
            case "lion":
                System.out.print("Length thing: ");
                double lionTailLength = scanner.nextDouble();
                scanner.nextLine();
                Lion newLion = new Lion(species, name, favoriteFood, age, entryDate, weight, height, lionTailLength);
                addLion(newLion);
                addAnimals(newLion);
                break;
            case "tiger":
                System.out.print("Length thing: ");
                double tigerTailLength = scanner.nextDouble();
                scanner.nextDouble();
                Tiger newTiger = new Tiger(species, name, favoriteFood, age, entryDate, weight, height, tigerTailLength);
                addTiger(newTiger);
                addAnimals(newTiger);

                break;
            case "eagle":
                System.out.print("Wing width: ");
                double eagleWingWidth = scanner.nextDouble();
                scanner.nextDouble();
                Eagle newEagle = new Eagle(species, name, favoriteFood, age, entryDate, weight, height, eagleWingWidth);
                addEagle(newEagle);
                addAnimals(newEagle);
                break;
        }

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

        System.out.println("the " + species + " tallest is " + specimentTallest.getName() +
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

        System.out.println("The " + species + " lower is " + specimentLower.getName() +
                "  with height " + specimentLower.getHeight() + " cm");
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
                " with weight " + specimentHeavier.getWeight() + " kg");
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
                " with weight " + specimentLighter.getWeight() + " kg");
    }

    public void findLongerTail(String species) {
        if( species.equalsIgnoreCase("lion")){
           List<Lion> lionList = getLions();
           Lion lion= lionList.stream().max(Comparator.comparingDouble(Lion::getTailLength)).orElse(null);
            System.out.println("the lion with the longest tail is : " + lion.getName() +
                    " with measure " + lion.getTailLength() + " cm");
        } else if(species.equalsIgnoreCase("tiger")) {
            List<Tiger> tigerList = getTigers();
            Tiger tiger= tigerList.stream().max(Comparator.comparingDouble(Tiger::getTailLength)).orElse(null);
            System.out.println("the tiger with the longest tail is : " + tiger.getName() +
                    " with measure " + tiger.getTailLength() + " cm");
        }
    }
    public void findWidestWingWidth(String species) {
        if( species.equalsIgnoreCase("eagle")){
            List<Eagle> eagleist = getEagles();
            Eagle eagle= eagleist.stream().max(Comparator.comparingDouble(Eagle::getWingWidth)).orElse(null);
            System.out.println("the eagle with the greatest wingspan is : " + eagle.getName() +
                    " with measure " + eagle.getWingWidth() + " cm");
        }
    }





}
