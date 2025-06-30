package OOP.L02_Encapsulation.demo;

public class Person {
    private String name; //-> когато нямаме аксес модифайър това означава, че най-отпред стои дефолтен такъв

    private int length;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
