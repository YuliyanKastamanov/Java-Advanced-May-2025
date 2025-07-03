package OOP.L03_Inheritance.P06_Animals;

public class Tomcat extends Cat{

    private static final String GENDER = "Male";
    private static final String TOMCAT_SOUND = "MEOW";


    public Tomcat(String name, int age, String gender) {
        super(name, age, GENDER);
    }

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return TOMCAT_SOUND;
    }
}
