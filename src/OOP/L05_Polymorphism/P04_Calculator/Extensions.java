package OOP.L05_Polymorphism.P04_Calculator;

public class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine){
        return new ExtendedInterpreter(engine);
    }
}
