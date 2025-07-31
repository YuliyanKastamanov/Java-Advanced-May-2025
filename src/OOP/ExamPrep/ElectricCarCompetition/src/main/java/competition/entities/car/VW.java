package competition.entities.car;

public class VW extends BaseCar{

    public static final int BATTERY_CAPACITY = 50;

    public VW(String model) {
        super(model, BATTERY_CAPACITY);
    }
}
