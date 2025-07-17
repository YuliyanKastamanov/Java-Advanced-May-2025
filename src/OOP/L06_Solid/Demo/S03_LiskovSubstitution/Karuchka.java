package OOP.L06_Solid.Demo.S03_LiskovSubstitution;

public class Karuchka extends Car{

    @Override
    public void startEngine() {

        throw new UnsupportedOperationException("Karuchka doesn't have engine.");
    }

    @Override
    public void drive() {
        System.out.println("Karuchka is moving.");
    }

    @Override
    public void stopEngine() {
        throw new UnsupportedOperationException("Karuchka doesn't have engine.");
    }
}
