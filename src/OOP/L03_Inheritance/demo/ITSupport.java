package OOP.L03_Inheritance.demo;

public class ITSupport {

    private String name;
    private double salary;
    private int solvedTickets;

    private void present(){
        System.out.printf("My name is %s and my salary is %.2f", name, salary);
    }

    private void assignTicket(){
        System.out.println("Ticket assigned!");
    }
}
