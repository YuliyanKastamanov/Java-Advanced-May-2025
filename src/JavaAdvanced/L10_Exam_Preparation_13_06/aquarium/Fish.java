package JavaAdvanced.L10_Exam_Preparation_13_06.aquarium;

public class Fish {


    private String name;
    private String color;
    private int fins;

    public Fish(String name, String color, int fins) {
        this.name = name;
        this.color = color;
        this.fins = fins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFins() {
        return fins;
    }

    public void setFins(int fins) {
        this.fins = fins;
    }


    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Fish: %s%n", name))
                .append(String.format("Color: %s%n", color))
                .append(String.format("Number of fins: %d", fins));

        return builder.toString();
    }
}
