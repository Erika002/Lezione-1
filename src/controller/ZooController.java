package controller;
import Interface.SpeciesInfo;
import Main.Species;
import Utility.ClassScanner;
import Utility.InteractionWithTheUser;
import entity.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ZooController {
    InteractionWithTheUser interactionWithTheUser = new InteractionWithTheUser();
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final Map<Main.Species, List<Animal>> animalMap = new HashMap<>();
        public ZooController() {
            initializeSpeciesMap();
        }


    private void initializeSpeciesMap() {
        Set<Class<?>> speciesClasses = ClassScanner.getClassesWithAnnotation(SpeciesInfo.class, "entity");
        for (Class<?> speciesClass : speciesClasses) {
            SpeciesInfo speciesInfo = speciesClass.getAnnotation(SpeciesInfo.class);
            String speciesName = speciesInfo.name();
            try {
                Main.Species speciesEnum = Species.valueOf(speciesName);
                animalMap.put(speciesEnum, new ArrayList<>());
            } catch (IllegalArgumentException e) {
                interactionWithTheUser.errorMessage(speciesName);
                System.exit(1);
            }
        }
    }


    public void insertAnimal(Species species) {
            interactionWithTheUser.printMessage(species);
            String name = interactionWithTheUser.insertString("name: ");
            String favoriteFood = interactionWithTheUser.insertString("Favorite food: ");
            int age = interactionWithTheUser.insertInt("Age: ");
            double weight = interactionWithTheUser.insertDouble("Weight: ");
            double height = interactionWithTheUser.insertDouble("Height: ");
            String date = interactionWithTheUser.insertString("Date of entry into the zoo (format dd-MM-yyyy): ");
            LocalDate entryDate = LocalDate.parse(date, dateFormatter);
            switch (species) {
                case LION:
                    double lionTailLength = interactionWithTheUser.insertDouble("Length of tail: ");
                    Lion newLion = new Lion(species.toString(), name, favoriteFood, age, entryDate, weight, height, lionTailLength);
                    animalMap.computeIfAbsent(species, k -> new ArrayList<>()).add(newLion);
                    break;
                case TIGER:
                    double tigerTailLength = interactionWithTheUser.insertDouble("Length of tail: ");
                    Tiger newTiger = new Tiger(species.toString(), name, favoriteFood, age, entryDate, weight, height, tigerTailLength);
                    animalMap.computeIfAbsent(species, k -> new ArrayList<>()).add(newTiger);
                    break;
                case EAGLE:
                    double eagleWingWidth = interactionWithTheUser.insertDouble("Wing width: ");
                    Eagle newEagle = new Eagle(species.toString(), name, favoriteFood, age, entryDate, weight, height, eagleWingWidth);
                    animalMap.computeIfAbsent(species, k -> new ArrayList<>()).add(newEagle);
                    break;
                default:
                    interactionWithTheUser.printMessageDefault();
            }
        }

        public List<Animal> getAnimalMapBySpecies(Species species) {
            return animalMap.getOrDefault(species, Collections.emptyList());
        }


        public void findTallerSpecimen(Species species) {
            List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);
            if (animalSpeciesList.isEmpty()) {
                interactionWithTheUser.printMessageSpeciesNotFound(species);
            }
            animalSpeciesList.stream()
                    .max(Comparator.comparingDouble(Animal::getHeight))
                    .ifPresent(specimenTallest -> interactionWithTheUser.messageFindTallerSpecimen(species, specimenTallest));
        }


        public void findLowerSpecimen(Species species) {
            List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);

            if (animalSpeciesList.isEmpty()) {
                interactionWithTheUser.printMessageSpeciesNotFound(species);
            }

            animalSpeciesList.stream()
                    .min(Comparator.comparingDouble(Animal::getHeight))
                    .ifPresent(specimenLower -> interactionWithTheUser.messageFindLowerSpecimen(species, specimenLower));

        }
        public void findHeaviestSpecimen(Species species) {
            List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);

            if (animalSpeciesList.isEmpty()) {
                interactionWithTheUser.printMessageSpeciesNotFound(species);
            }
            animalSpeciesList.stream()
                    .max(Comparator.comparingDouble(Animal::getWeight))
                   .ifPresent(heaviestSpecimen -> interactionWithTheUser.messageFindHeavierSpecimen(species, heaviestSpecimen));
        }

        public void findLightestSpecimen(Species species) {
            List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);

            if (animalSpeciesList.isEmpty()) {
                interactionWithTheUser.printMessageSpeciesNotFound(species);
            }
            animalSpeciesList.stream()
                    .min(Comparator.comparingDouble(Animal::getWeight))
                    .ifPresent(specimenLighter -> interactionWithTheUser.messageFindLighterSpecimen(species, specimenLighter));
        }


        public void findLongestTailOfASpecies(Species species) {
            List<Animal> animalSpeciesMap = getAnimalMapBySpecies(species);
            if (animalSpeciesMap.isEmpty()) {
                interactionWithTheUser.printMessageSpeciesNotFound(species);
            }
            Animal longestTailAnimal = animalSpeciesMap.stream()
                    .filter(AnimalWithTail.class::isInstance)
                    .max(Comparator.comparingDouble(animal -> ((AnimalWithTail) animal).getTailLength()))
                    .orElse(null);

            interactionWithTheUser.messageFindLongestTailOfASpecies(species, longestTailAnimal);
        }

        public void findWidestWingWidthOfASpecies(Species species) {
            List<Animal> animalSpeciesList = getAnimalMapBySpecies(species);
            if (animalSpeciesList.isEmpty()) {
                interactionWithTheUser.printMessageSpeciesNotFound(species);
            }
            Animal widestWingWidthAnimal = animalSpeciesList.stream()
                    .filter(AnimalWithWings.class::isInstance)
                    .max(Comparator.comparingDouble(animal -> ((AnimalWithWings) animal).getWingWidth()))
                    .orElse(null);
            interactionWithTheUser.messageFindWidestWingWidthOfASpecies(species, widestWingWidthAnimal);
        }


        public void findWidestWingWidthAcrossAllSpecies() {
            List<AnimalWithWings> animalsWithWings =
                    animalMap.values().stream().flatMap(Collection::stream)
                            .filter(AnimalWithWings.class::isInstance)
                            .map(AnimalWithWings.class::cast)
                            .toList();

            if (animalsWithWings.isEmpty()) {
                interactionWithTheUser.messageNoAnimalsWithWing();
            }

            animalsWithWings.stream()
                    .max(Comparator.comparingDouble(AnimalWithWings::getWingWidth))
                    .ifPresent(widestWingWidthAnimal -> interactionWithTheUser.messageAllAnimalsWithWing(widestWingWidthAnimal));
        }

        public void findLongestTailAcrossAllSpecies() {
            List<AnimalWithTail> animalsWithTail =
                    animalMap.values().stream().flatMap(Collection::stream)
                            .filter(AnimalWithTail.class::isInstance)
                            .map(AnimalWithTail.class::cast)
                            .toList();
            if (animalsWithTail.isEmpty()) {
                interactionWithTheUser.messageNoAnimalsWithTail();
            }
            animalsWithTail.stream()
                    .max(Comparator.comparingDouble(AnimalWithTail::getTailLength))
                    .ifPresent(longestTailAnimal -> interactionWithTheUser.messageAllAnimalsWithTail(longestTailAnimal));
        }


    }
