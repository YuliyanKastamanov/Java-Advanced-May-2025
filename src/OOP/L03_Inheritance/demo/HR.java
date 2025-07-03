package OOP.L03_Inheritance.demo;

public class HR {

    private String name;
    private double salary;
    private int hiredEmployees;

    private void present(){
        System.out.printf("My name is %s and my salary is %.2f", name, salary);
    }

    private void checkCV(){
        System.out.println("CV checked!");
    }
}
