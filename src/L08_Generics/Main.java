package L08_Generics;

public class Main {
    public static void main(String[] args) {

        Product<String> productName = new Product<>();
        Product<Double> productPrice = new Product<>();
        Product<Integer> productCount = new Product<>();

        productName.printProductData("Orange", "Banana");
        productPrice.printProductData(5.00, 3.80);
        productCount.printProductData(10, 20);



    }
}
