package OOP.L03_Inheritance.P06_Animals;

public class Dog extends Animal{

    private static final String DOG_SOUND = "Woof!";
    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return DOG_SOUND;
    }
}
