package OOP.L04_InterfacesAndAbstraction.demo;


public abstract class Pizza {

    private String name;
    private double price;

    public void bake(){
        System.out.printf("Pizza %s baked!", name);
    }

    public void deliver(){
        System.out.printf("Pizza %s is ready to be delivered. The price is: %.2f", name, price);
    }

    public abstract String getIngredients();




}
