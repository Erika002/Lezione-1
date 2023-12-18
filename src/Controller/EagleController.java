package Controller;
import Entity.Eagle;
import java.util.*;

public class EagleController {

    public static EagleController instance;

    private List<Eagle> eagles;

    public EagleController() {
        this.eagles =  new ArrayList<>();
    }
    public static EagleController getInstance() {
        if (instance == null) {
            instance = new EagleController();
        }
        return instance;
    }
    public void addEagle(Eagle eagle) {
        eagles.add(eagle);
    }

    public List<Eagle> getEagles() {
        return eagles;
    }

    public void widerWingWidth() {
        List<Eagle> eagles = getEagles();

        if (eagles.isEmpty()) {
            System.out.println("No eagles present in the zoo.");
        }

        Eagle wingWidth = eagles.stream()
                .max(Comparator.comparingDouble(Eagle::getWingWidth))
                .orElse(null);

        System.out.println("The eagle with the widest wingspan is: " + wingWidth.getName() +
                " with width" + wingWidth.getWingWidth() + "cm");
    }
}


