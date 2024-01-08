import controller.ZooController;
import entity.AnimalWithTail;
import entity.AnimalWithWings;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    enum Species {
        LION,
        TIGER,
        EAGLE
    }

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ZooController zooController = new ZooController();

        String insert = "";

        do {
            System.out.println("Choose the new animal to insert:");
            System.out.println("1. Lion");
            System.out.println("2. Tiger");
            System.out.println("3. Eagle");

            int animalChoice = scanner.nextInt();
            scanner.nextLine();

            Species species = null;

            switch (animalChoice) {
                case 1:
                    species = Species.LION;
                    break;
                case 2:
                    species = Species.TIGER;
                    break;
                case 3:
                    species = Species.EAGLE;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }

            assert species != null;
            zooController.insertAnimal(scanner, species.toString());

            System.out.println("To insert a new animal, type '+'. Otherwise, type '-':");
            insert = scanner.nextLine();
        } while (!insert.equals("-"));

        System.out.println("Choose a species for your search:");
        System.out.println("1. Lion");
        System.out.println("2. Tiger");
        System.out.println("3. Eagle");

        int speciesChoice = scanner.nextInt();
        scanner.nextLine();

        Species selectedSpecies = null;
        switch (speciesChoice) {
            case 1:
                selectedSpecies = Species.LION;
                break;
            case 2:
                selectedSpecies = Species.TIGER;
                break;
            case 3:
                selectedSpecies = Species.EAGLE;
                break;
            default:
                System.out.println("Invalid choice. Exiting the program.");
                return;
        }

        int choice;
        do {
            System.out.println("Choose an option:");
            System.out.println("1. Find the tallest specimen among " + selectedSpecies);
            System.out.println("2. Find the lowest specimen among " + selectedSpecies);
            System.out.println("3. Find the heaviest specimen among " + selectedSpecies);
            System.out.println("4. Find the lightest specimen among " + selectedSpecies);
            if (selectedSpecies == Species.LION || selectedSpecies == Species.TIGER) {
                System.out.println("5. Find the specimen with the longest tail");
            } else {
                System.out.println("5. Find the specimen with the largest wingspan");
            }
            System.out.println("6. Find the animal with the longest tail");
            System.out.println("7. Find the animal with the widest wingspan");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    zooController.findTallerSpecimen(selectedSpecies.toString());
                    break;
                case 2:
                    zooController.findLowerSpecimen(selectedSpecies.toString());
                    break;
                case 3:
                    zooController.findHeavierSpecimen(selectedSpecies.toString());
                    break;
                case 4:
                    zooController.findLighterSpecimen(selectedSpecies.toString());
                    break;
                case 5:
                    boolean selectedSpeciesHasWithTails = zooController.getAnimalsBySpecies(selectedSpecies.toString()).stream()
                            .anyMatch(AnimalWithTail.class::isInstance);

                    if (selectedSpeciesHasWithTails) {
                        zooController.findLongestTailOfASpecies(selectedSpecies.toString());
                        break;
                    }

                    boolean selectedSpeciesHasWithWings = zooController.getAnimalsBySpecies(selectedSpecies.toString()).stream()
                            .anyMatch(AnimalWithWings.class::isInstance);

                    if (selectedSpeciesHasWithWings) {
                        zooController.findWidestWingWidthOfASpecies(selectedSpecies.toString());
                        break;
                    }
                    System.out.println("The selected species does not have tail or wings.");

                    break;
                case 6:
                    zooController.findLongestTailAcrossAllSpecies();
                    break;
                case 7:
                    zooController.findWidestWingWidthAcrossAllSpecies();
                    break;
                case 0:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        } while (choice != 0);

        scanner.close();

    }
}
