import Controller.EagleController;
import Controller.LeonController;
import Controller.TigerController;
import Controller.ZooController;

import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        ZooController zooController = new ZooController();
        LeonController leonController = LeonController.getInstance();
        TigerController tigerController = TigerController.getInstance();
        EagleController eagleController = EagleController.getInstance();

        String insert = "";

        do {
            System.out.println("Choose the new animal to insert:");
            System.out.println("1. Leon");
            System.out.println("2. Tiger");
            System.out.println("3. Eagle");

            int animalChoice = scanner.nextInt();
            scanner.nextLine();

            switch (animalChoice) {
                case 1:
                    zooController.insertAnimal(scanner, "Leon");
                    break;
                case 2:
                    zooController.insertAnimal(scanner, "Tiger");
                    break;
                case 3:
                    zooController.insertAnimal(scanner, "Eagle");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }

            System.out.println("To insert a new animal, type '+'. Otherwise, type '-':");
            insert = scanner.nextLine();
        } while (!insert.equals("-"));

        if (insert.equals("-")) {
            System.out.println("Choose a species for your search:");
            System.out.println("1. Leon");
            System.out.println("2. Tiger");
            System.out.println("3. Eagle");

            int speciesChoice = scanner.nextInt();
            scanner.nextLine();

            String species = "";
            switch (speciesChoice) {
                case 1:
                    species = "Leon";
                    break;
                case 2:
                    species = "Tiger";
                    break;
                case 3:
                    species = "Eagle";
                    break;
                default:
                    System.out.println("Invalid choice. Exiting the program.");
                    return;
            }
            int choice;
            do {
                System.out.println("Choose an option:");
                System.out.println("1. Find the tallest specimen among" + species);
                System.out.println("2. Find the lowest specimen among " + species);
                System.out.println("3. Find the heaviest specimen among" + species);
                System.out.println("4. Find the lightest specimen among " + species);
                if (species.equalsIgnoreCase("leon") || species.equalsIgnoreCase("tiger")) {
                    System.out.println("5. Find the specimen with the longest tail");
                } else if (species.equalsIgnoreCase("eagle")) {
                    System.out.println("5. Find the specimen with the largest wingspan");
                }
                System.out.println("0. Exit");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        zooController.findTallerSpecimen(species);
                        break;
                    case 2:
                        zooController.findLowerSpecimen(species);
                        break;
                    case 3:
                        zooController.findHeavierSpecimen(species);
                        break;
                    case 4:
                        zooController.findLighterSpecimen(species);
                        break;
                    case 5:
                        if (species.equalsIgnoreCase("leon")) {
                            leonController.longerTail();
                        } else if (species.equalsIgnoreCase("tiger")) {
                            tigerController.longerTail();
                        } else if (species.equalsIgnoreCase("eagle")) {
                            eagleController.widerWingWidth();
                        }
                        break;
                    case 0:
                        System.out.println("Exiting the program.");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            } while (choice != 0);
        }

        scanner.close();
    }
}
