package furnitureShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class ShopTests {
    //TODO write unit tests

    private Furniture furniture1;
    private Furniture furniture2;
    private Shop shop;

    @BeforeEach
    public void setUp(){
        this.furniture1 = new Furniture("Sofa", "LivingRoomSofa", 400);
        this.furniture2 = new Furniture("Chair", "KitchenChair", 100);
        this.shop = new Shop("Furniture Store", 2);
    }

    @Test
    public void testAddFurnitureSuccessfully(){
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        Assertions.assertEquals(2, shop.getFurnitures().size());
    }

    @Test
    public void testAddNullFurniture(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            shop.addFurniture(null);
        });
    }

    @Test
    public void testAddFurnitureNotEnoughSpace(){
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        Furniture furniture = new Furniture("Chair1", "KitchenChair", 100);
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            shop.addFurniture(furniture);
        });
    }

    @Test
    public void testAddExistingFurniture(){
        shop.addFurniture(furniture1);
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            shop.addFurniture(furniture1);
        });
    }

    @Test
    public void testRemoveFurniture(){
        shop.addFurniture(furniture1);
        Assertions.assertTrue(shop.removeFurniture("LivingRoomSofa"));
    }

    @Test
    public void testGetCheapestFurniture(){
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);

        Assertions.assertEquals("Chair", shop.getCheapestFurniture());
    }

    @Test
    public void testFindAllByType(){
        Furniture furniture = new Furniture("Chair1", "KitchenChair", 100);
        shop = new Shop("TestShop", 3);
        shop.addFurniture(furniture);
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);

        List<Furniture> chairs = shop.findAllFurnitureByType("KitchenChair");
        Assertions.assertEquals(2, chairs.size());
        Assertions.assertEquals(furniture, chairs.get(0));
        Assertions.assertEquals(furniture2, chairs.get(1));

    }

    @Test
    public void testGetType(){
        Assertions.assertEquals("Furniture Store", shop.getType());
    }

    @Test
    public void testGetCount(){
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        Assertions.assertEquals(2, shop.getCount());
    }

    @Test
    public void testShopCapacityBellowZero(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            shop = new Shop("TestShop", -1);
        });
    }

}