package Main;

import Utility.InteractionWithTheUser;
import controller.ZooController;
import entity.AnimalWithTail;
import entity.AnimalWithWings;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ZooController zooController = new ZooController();
        InteractionWithTheUser interactionWithTheUser = new InteractionWithTheUser();

        String insert = "";

        do {
            interactionWithTheUser.insertAnimal();

            int animalChoice = scanner.nextInt();
            scanner.nextLine();

            Species species = switch (animalChoice) {
                case 1 -> Species.LION;
                case 2 -> Species.TIGER;
                case 3 -> Species.EAGLE;
                default -> null;
            };

            zooController.insertAnimal(species);

            interactionWithTheUser.messageInsert();
            insert = scanner.nextLine();
        } while (!insert.equals("-"));

        interactionWithTheUser.chooseAnimal();

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
                interactionWithTheUser.invalidChoice();
                break;
        }

        int choice;
        do {
            interactionWithTheUser.chooseAnOption(selectedSpecies);

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    zooController.findTallerSpecimen(selectedSpecies);
                    break;
                case 2:
                    zooController.findLowerSpecimen(selectedSpecies);
                    break;
                case 3:
                    zooController.findHeaviestSpecimen(selectedSpecies);
                    break;
                case 4:
                    zooController.findLightestSpecimen(selectedSpecies);
                    break;
                case 5:
                    boolean selectedSpeciesHasWithTails = zooController.getAnimalMapBySpecies(selectedSpecies).stream()
                            .anyMatch(AnimalWithTail.class::isInstance);

                    if (selectedSpeciesHasWithTails) {
                        zooController.findLongestTailOfASpecies(selectedSpecies);
                        break;
                    }

                    boolean selectedSpeciesHasWithWings = zooController.getAnimalMapBySpecies(selectedSpecies).stream()
                            .anyMatch(AnimalWithWings.class::isInstance);

                    if (selectedSpeciesHasWithWings) {
                        zooController.findWidestWingWidthOfASpecies(selectedSpecies);
                        break;
                    }
                    break;
                case 6:
                    zooController.findLongestTailAcrossAllSpecies();
                    break;
                case 7:
                    zooController.findWidestWingWidthAcrossAllSpecies();
                    break;
                case 0:
                    interactionWithTheUser.exit();
                    break;
                default:
                    interactionWithTheUser.invalidChoice();
                    break;
            }
        } while (choice != 0);

        scanner.close();

    }
}
