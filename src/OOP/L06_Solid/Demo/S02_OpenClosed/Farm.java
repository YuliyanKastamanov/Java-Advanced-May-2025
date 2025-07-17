package OOP.L06_Solid.Demo.S02_OpenClosed;

import java.util.List;

public class Farm {


    private List<Animal> animals;

    public void walkAnimals(){
        for (Animal animal : animals){
            animal.walk();
        }
    }
}
