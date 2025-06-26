package JavaAdvanced.L08_Generics;

public class Product<E> {

    public void printProductName(String product1, String product2){

        System.out.println(product1);
        System.out.println(product2);
    }

    public void printProductPrice(double price1, double price2){

        System.out.println(price1);
        System.out.println(price2);
    }

    public void printProductCount(int count1, int count2) {

        System.out.println(count1);
        System.out.println(count2);
    }

    //E, T, U,
    public void printProductData(E product1, E product2){
        System.out.println(product1);
        System.out.println(product2);
    }
}
