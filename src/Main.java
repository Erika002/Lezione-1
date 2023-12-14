import Controller.ZooController;
import Entity.Zoo;

import java.text.ParseException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {
        Zoo zoo = new Zoo();

        String inserisci = "";
        ZooController controller = new ZooController(zoo);

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println(" inserisci un animale: ");
            controller.inserisciAnimale();
            System.out.println(" per inserire un nuovo animale digita + ");
            System.out.println(" per proseguire digita - ");
            inserisci = scanner.nextLine();


        } while (!inserisci.equals("-"));


        int scelta;
        int sceltaSpecie = 0;
        String specie = " ";

        if (inserisci.equals("-")) {
            System.out.println(" Scegli una specie per la tua ricerca ");
            System.out.println("1. Leone");
            System.out.println("2. Tigre");
            System.out.println("3. Aquila");
            sceltaSpecie = scanner.nextInt();

            switch (sceltaSpecie) {
                case 1:
                    specie = "Leone";
                    break;
                case 2:
                    specie = "Tigre";
                    break;
                case 3:
                    specie = "Aquila";
                    break;
            }

        if(sceltaSpecie != 0) {
            System.out.println("lista di tutti gli animali presenti nello zoo \n" + zoo.toString());
            do {
                System.out.println("Scegli un'opzione:");
                System.out.println("1. Trova l'esemplare più alto e più basso tra " + specie);
                System.out.println("2. Trova l'esemplare più pesante e più leggero tra " + specie);
                if (specie.equalsIgnoreCase("leone") || specie.equalsIgnoreCase("tigre")) {
                    System.out.println("3. Trova l'esemplare con la coda più lunga");
                } else if (specie.equalsIgnoreCase("aquila")) {
                    System.out.println("3. Trova l'esemplare con l'apertura alare più larga");
                }
                System.out.println("0. Esci");

                scelta = scanner.nextInt();


                switch (scelta) {
                    case 1:
                        controller.trovaEsemplareAltoEBassoPerSpecie(specie);
                        break;
                    case 2:
                        controller.trovaEsemplarePesanteELeggeroPerSpecie(specie);
                        break;
                    case 3:
                        controller.trovaEsemplareMisuraLunga(specie);
                        break;
                    case 0:
                        System.out.println("Uscita dal programma.");
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                }
            } while (scelta != 0);
        }
        }

            scanner.close();


    }
}