package OOP.L04_InterfacesAndAbstraction.demo;

public abstract class BasePerson implements Person {

    private String name;
    private int age;

    public BasePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
