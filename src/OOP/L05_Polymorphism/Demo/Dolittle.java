package OOP.L05_Polymorphism.Demo;

public class Dolittle {

    public void healCat(Cat cat){

        if(cat instanceof Lion){
            ((Lion) cat).roar();
        }
        System.out.printf("%s has been healed and ready to run.%n", cat.getClass().getSimpleName());
        cat.run();

    }

   /* public void healTiger(Tiger tiger){
        System.out.println("Tiger has been healed and ready to run.");
        tiger.run();
    }

    public void healJaguar(Jaguar jaguar){
        System.out.println("Jaguar has been healed and ready to run.");
        jaguar.run();
    }*/
}
