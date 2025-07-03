package OOP.L03_Inheritance.demo;

public class Engineer extends Employee{

    /*private String name;
    private double salary;*/
    private String authorization;

    public Engineer(String name, double salary) {
        super(name, salary);
    }

    public Engineer(double salary) {
        super(salary);
    }






    /*private void present(){
        System.out.printf("My name is %s and my salary is %.2f", name, salary);
    }*/

    public String getAuthorization() {
        return authorization;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public void prepareProject(){
        System.out.println("Project finished!");
    }
}
