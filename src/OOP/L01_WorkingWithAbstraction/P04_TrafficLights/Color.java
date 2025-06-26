package OOP.L01_WorkingWithAbstraction.P04_TrafficLights;

public enum Color {

    //red -> green -> yellow -> red
    RED("GREEN"),
    GREEN("YELLOW"),
    YELLOW("RED");


    private String nextColor;

    Color(String color) {
        this.nextColor = color;
    }

    public String getNextColor() {
        return nextColor;
    }

    public void setNextColor(String nextColor) {
        this.nextColor = nextColor;
    }
}
