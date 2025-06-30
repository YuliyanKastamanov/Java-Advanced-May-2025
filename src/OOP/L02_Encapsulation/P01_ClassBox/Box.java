package OOP.L02_Encapsulation.P01_ClassBox;

public class Box {

    //length, width, and height

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        //this.length = length;
        setWidth(width);
        setHeight(height);
    }



    private void setLength(double length) {
        //проверяваме дължината
        if(length > 0){
            this.length = length;
        }else {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
    }

    private void setWidth(double width) {
        //проверяваме дали ширината е положително число
        if(width > 0){
            this.width = width;
        }else {
            throw new IllegalArgumentException("Width cannot be zero or negative.");

        }
    }

    private void setHeight(double height) {
        //проверяваме дали височината е положително число
        if(height > 0){
            this.height = height;
        }else {
            throw new IllegalArgumentException("Height cannot be zero or negative.");

        }

    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double calculateSurfaceArea(){
        //Surface Area = 2lw + 2lh + 2wh
        return (2 * length * width) + (2 * length * height) + (2 * width * height);
    }

    public double calculateLateralSurfaceArea(){
        //Lateral Surface Area = 2lh + 2wh
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume(){
        //Volume = lwh
        return length * width * height;
    }


}
