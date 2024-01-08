package controller;
import entity.*;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ZooController {

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private final List<Animal> animals;

    private final Map<String, List<Animal>> animalMap = new HashMap<>();

    public ZooController() {
        this.animals = new ArrayList<>();
    }

    public List<Animal> getAnimals() {
        return animals;
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
                animals.add(newLion);
                animalMap.computeIfAbsent(species, k -> new ArrayList<>()).add(newLion);
                break;
            case "tiger":
                System.out.print("Length thing: ");
                double tigerTailLength = scanner.nextDouble();
                scanner.nextLine();
                Tiger newTiger = new Tiger(species, name, favoriteFood, age, entryDate, weight, height, tigerTailLength);
                animals.add(newTiger);
                animalMap.computeIfAbsent(species, k -> new ArrayList<>()).add(newTiger);
                break;
            case "eagle":
                System.out.print("Wing width: ");
                double eagleWingWidth = scanner.nextDouble();
                scanner.nextLine();
                Eagle newEagle = new Eagle(species, name, favoriteFood, age, entryDate, weight, height, eagleWingWidth);
                animals.add(newEagle);
                animalMap.computeIfAbsent(species, k -> new ArrayList<>()).add(newEagle);
                break;
            default:
                System.out.println("Unrecognized species. Please enter a valid species.");
        }
    }
    private List<Animal> getAnimalMapBySpecies(String species) {
        return animalMap.getOrDefault(species, Collections.emptyList());
    }


    public void findTallerSpecimen(String species) {
        List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);
        if (animalSpeciesList.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }
        Animal specimenTallest = animalSpeciesList.stream()
                .max(Comparator.comparingDouble(Animal::getHeight))
                .orElse(null);

            System.out.println("The " + species + " tallest is " + specimenTallest.getName() +
                    " with height " + specimenTallest.getHeight() + "cm");

    }



    public void findLowerSpecimen(String species) {
        List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);

        if (animalSpeciesList.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal specimenLower = animalSpeciesList.stream()
                .min(Comparator.comparingDouble(Animal::getHeight))
                .orElse(null);

            System.out.println("The " + species + " lower is " + specimenLower.getName() +
                    " with height " + specimenLower.getHeight() + "cm");

    }


    public void findHeavierSpecimen(String species) {
        List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);

        if (animalSpeciesList.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal specimenHeavier = animalSpeciesList.stream()
                .max(Comparator.comparingDouble(Animal::getWeight))
                .orElse(null);

            System.out.println("The " + species + " heavier is " + specimenHeavier.getName() +
                    " with weight " + specimenHeavier.getWeight() + "kg");
    }


    public void findLighterSpecimen(String species) {
        List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);

        if (animalSpeciesList.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal specimenLighter = animalSpeciesList.stream()
                .min(Comparator.comparingDouble(Animal::getWeight))
                .orElse(null);

            System.out.println("The " + species + " lighter is " + specimenLighter.getName() +
                    " with weight " + specimenLighter.getWeight() + "kg");
    }


    public void findLongestTailOfASpecies(String species) {
        List<Animal> animalSpeciesMap = getAnimalMapBySpecies(species);

        if (animalSpeciesMap.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal longestTailAnimal = animalSpeciesMap.stream()
                .filter(AnimalWithTail.class::isInstance)
                .max(Comparator.comparingDouble(animal -> ((AnimalWithTail) animal).getTailLength()))
                .orElse(null);

        if (longestTailAnimal != null) {
            System.out.println("The " + species + " with the longest tail is: " +
                    longestTailAnimal.getName() + " with measure " +
                    ((AnimalWithTail) longestTailAnimal).getTailLength() + " cm");
        } else {
            System.out.println("No " + species + " with a tail present in the zoo.");
        }
    }

    public void findWidestWingWidthOfASpecies(String species) {
        List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);

        if (animalSpeciesList.isEmpty()) {
            System.out.println("No " + species + " present in the zoo.");
            return;
        }

        Animal widestWingWidthAnimal = animalSpeciesList.stream()
                .filter(AnimalWithWings.class::isInstance)
                .max(Comparator.comparingDouble(animal -> ((AnimalWithWings) animal).getWingWidth()))
                .orElse(null);

        if (widestWingWidthAnimal != null) {
            System.out.println("The " + species + " with the widest wingspan is: " +
                    widestWingWidthAnimal.getName() + " with measure " +
                    ((AnimalWithWings) widestWingWidthAnimal).getWingWidth() + " cm");
        } else {
            System.out.println("No " + species + " with wings present in the zoo.");
        }
    }


    public void findWidestWingWidthAcrossAllSpecies() {
        List<AnimalWithWings> animalsWithWings = getAnimals().stream()
                .filter(AnimalWithWings.class::isInstance)
                .map(AnimalWithWings.class::cast)
                .toList();

        if (animalsWithWings.isEmpty()) {
            System.out.println("No animals with wings present in the zoo.");
            return;
        }

        AnimalWithWings widestWingWidthAnimal = animalsWithWings.stream()
                .max(Comparator.comparingDouble(AnimalWithWings::getWingWidth))
                .orElse(null);

            System.out.println("The animal with the widest wingspan is: " +
                    widestWingWidthAnimal.getName() + " of species " + widestWingWidthAnimal.getSpecies() +
                    " with measure " + widestWingWidthAnimal.getWingWidth() + " cm");
    }

    public void findLongestTailAcrossAllSpecies() {
        List<AnimalWithTail> animalsWithTail = getAnimals().stream()
                .filter(AnimalWithTail.class::isInstance)
                .map(AnimalWithTail.class::cast)
                .toList();

        if (animalsWithTail.isEmpty()) {
            System.out.println("No animals with tail present in the zoo.");
            return;
        }

        AnimalWithTail longestTailAnimal = animalsWithTail.stream()
                .max(Comparator.comparingDouble(AnimalWithTail::getTailLength))
                .orElse(null);

            System.out.println("The animal with the longest tail is: " +
                    longestTailAnimal.getName() + " of species " + longestTailAnimal.getSpecies() +
                    " with measure " + longestTailAnimal.getTailLength() + " cm");
    }






}
