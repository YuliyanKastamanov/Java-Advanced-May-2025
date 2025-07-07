package OOP.L04_InterfacesAndAbstraction.demo;

public class BulgarianPerson extends BasePerson{


    public BulgarianPerson(String name, int age) {
        super(name, age);
    }

    @Override
    public void present() {
        System.out.printf("Hello my name is: %s. I'm from Bulgaria.", super.getName());
    }


}
