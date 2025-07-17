package OOP.ExamPrep.ElectricCarCompetition.entities.car;

public class Tesla extends BaseCar{

    public static final int BATTERY_CAPACITY = 85;

    public Tesla(String model) {
        super(model, BATTERY_CAPACITY);
    }
}
