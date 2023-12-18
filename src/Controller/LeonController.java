package Controller;
import Entity.Leon;
import java.util.*;

public class LeonController {
    private static LeonController instance;
    private List<Leon> leons;

    public LeonController() {
        this.leons =  new ArrayList<>();
    }

    public static LeonController getInstance() {
        if (instance == null) {
            instance = new LeonController();
        }
        return instance;
    }
    public void addLeons(Leon leon) {
        leons.add(leon);
    }

    public List<Leon> getLeons() {
        return leons;
    }

    public void longerTail() {
        List<Leon> leons = getLeons();

        if (leons.isEmpty()) {
            System.out.println("No lions present in the zoo.");
        }

        Leon longTail = leons.stream()
                .max(Comparator.comparingDouble(Leon::getTailLength))
                .orElse(null);

            System.out.println("the lion with the longest tail is : " + longTail.getName() +
                    " with measure " + longTail.getTailLength() + "cm");
    }
}
