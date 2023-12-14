package Controller;
import Entity.Animale;
import Entity.Zoo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ZooController {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private Zoo zoo;

    public ZooController(Zoo zoo) {
        this.zoo = zoo;
    }

    public void inserisciAnimale() throws ParseException {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Seleziona la specie:");
        System.out.println("1. Leone");
        System.out.println("2. Tigre");
        System.out.println("3. Aquila");

        int sceltaSpecie = scanner.nextInt();

        String specie;
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
            default:
                System.out.println("Scelta non valida. Specie impostata su valore predefinito: Leone");
                specie = "Leone";
        }
        System.out.println("Inserisci i dettagli del nuovo animale:");


        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Cibo preferito: ");
        String ciboPreferito = scanner.nextLine();

        System.out.print("Età: ");
        int eta = scanner.nextInt();

        System.out.print("Peso: ");
        double peso = scanner.nextDouble();

        System.out.print("Altezza: ");
        double altezza = scanner.nextDouble();

        System.out.println("Data di ingresso nello zoo: ");
        String data = scanner.nextLine();
        Date dataIngresso = null;
        dataIngresso = simpleDateFormat.parse(data);

        double misura = 0.0;
        if(sceltaSpecie != 3) {
            System.out.print("Lunghezza coda: ");
             misura = scanner.nextDouble();
        } else {
            System.out.print("Apertura alare : ");
             misura = scanner.nextDouble();
        }

        Animale nuovoAnimale = new Animale(specie, nome, ciboPreferito, eta, dataIngresso, peso, altezza, misura);

        zoo.aggiungiAnimale(nuovoAnimale);
    }


    public void trovaEsemplareAltoEBassoPerSpecie(String specie) {
        List<Animale> animaliSpecie = zoo.getAnimaliBySpecie(specie);

        if (animaliSpecie.isEmpty()) {
            System.out.println("Nessun animale di specie " + specie + " presente nello zoo.");
        }

        Animale animalePiuAlto = animaliSpecie.stream()
                .max(Comparator.comparingDouble(Animale::getAltezza))
                .orElse(null);

        Animale animalePiuBasso = animaliSpecie.stream()
                .min(Comparator.comparingDouble(Animale::getAltezza))
                .orElse(null);

        System.out.println("l' animale più alto della specie " + specie + "è : " + animalePiuAlto.getNome() +
                    " con altezza " + animalePiuAlto.getAltezza() + "cm");
        System.out.println("l' animale più basso della specie " + specie + "è : " + animalePiuBasso.getNome() +
                " con altezza " + animalePiuBasso.getAltezza() + "cm");

    }


    public void trovaEsemplarePesanteELeggeroPerSpecie(String specie) {
        List<Animale> animaliSpecie = zoo.getAnimaliBySpecie(specie);

        if (animaliSpecie.isEmpty()) {
            System.out.println("Nessun animale di specie " + specie + " presente nello zoo.");
        }

        Animale animalePiuPesante = animaliSpecie.stream()
                .max(Comparator.comparingDouble(Animale::getPeso))
                .orElse(null);

        Animale animalePiuLeggero = animaliSpecie.stream()
                .min(Comparator.comparingDouble(Animale::getPeso))
                .orElse(null);

        System.out.println("l' animale più pesante della specie " + specie + " è : " + animalePiuPesante.getNome() +
                " con peso " + animalePiuPesante.getPeso() + "kg" );
        System.out.println("l' animale più leggero della specie " + specie + " è : " + animalePiuLeggero.getNome() +
                " con peso " + animalePiuLeggero.getPeso() + "kg");
    }

    public void trovaEsemplareMisuraLunga(String specie) {
        List<Animale> animaliSpecie = zoo.getAnimaliBySpecie(specie);

        if (animaliSpecie.isEmpty()) {
            System.out.println("Nessun animale di specie " + specie + " presente nello zoo.");
        }
        Animale animaleMisuraAmpia = animaliSpecie.stream()
                .max(Comparator.comparingDouble(Animale::getMisura))
                .orElse(null);
        if(!specie.equals( "aquila")) {
            System.out.println("l' animale con la coda più lunga della specie " + specie + " è : " + animaleMisuraAmpia.getNome() +
                    " con misura " + animaleMisuraAmpia.getMisura() + "cm");
        } else {
            System.out.println("l' animale con la larghezza alare più ampia della specie " + specie + " è : " + animaleMisuraAmpia.getNome() +
                    " con misura " + animaleMisuraAmpia.getMisura() + "cm");
        }

    }

}

