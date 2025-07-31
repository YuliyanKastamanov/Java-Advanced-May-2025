package competition.entities.car;

public class Hyundai extends BaseCar {

    public static final int BATTERY_CAPACITY = 60;

    public Hyundai(String model) {
        super(model, BATTERY_CAPACITY);
    }
}
