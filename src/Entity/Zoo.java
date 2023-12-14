package Entity;
import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animale> animali;

    public Zoo() {
        this.animali = new ArrayList<>();
    }

    public void aggiungiAnimale(Animale animale) {
        animali.add(animale);
    }

    public List<Animale> getAnimali() {
        return animali;
    }
    public List<Animale> getAnimaliBySpecie(String specie) {
        List<Animale> animaliSpecie = new ArrayList<>();

        for (Animale animale : animali) {
            if (animale.getSpecie().equalsIgnoreCase(specie)) {
                animaliSpecie.add(animale);
            }
        }

        return animaliSpecie;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "animali=" + animali +
                '}' + "\n";
    }

}

