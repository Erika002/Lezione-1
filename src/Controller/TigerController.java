package Controller;
import Entity.Tiger;
import java.util.*;

public class TigerController {

    public static TigerController instance;

    private List<Tiger> tigers;

    public TigerController() {
        this.tigers =  new ArrayList<>();
    }

    public static TigerController getInstance() {
        if (instance == null) {
            instance = new TigerController();
        }
        return instance;
    }

    public void addTigers(Tiger tiger) {
        tigers.add(tiger);
    }

    public List<Tiger> getTigers() {
        return tigers;
    }

    public void longerTail() {
        List<Tiger> tigers = getTigers();

        if (tigers.isEmpty()) {
            System.out.println("No tigers present in the zoo.");
        }

        Tiger longTail = tigers.stream()
                .max(Comparator.comparingDouble(Tiger::getTailLength))
                .orElse(null);

        System.out.println("The tiger with the longest tail is: " + longTail.getName() +
                " con length " + longTail.getTailLength() + "cm");
    }
}

