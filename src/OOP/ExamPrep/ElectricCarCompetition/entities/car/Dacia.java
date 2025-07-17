package OOP.ExamPrep.ElectricCarCompetition.entities.car;

public class Dacia extends BaseCar{

    public static final int BATTERY_CAPACITY = 30;


    public Dacia(String model) {
        super(model, BATTERY_CAPACITY);
    }
}
