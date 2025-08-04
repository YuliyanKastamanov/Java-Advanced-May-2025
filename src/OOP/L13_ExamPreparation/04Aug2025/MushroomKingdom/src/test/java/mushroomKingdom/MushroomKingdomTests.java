package mushroomKingdom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MushroomKingdomTests {

//TODO write unit tests here covering all the methods


    private Field field;
    private Mushroom mushroom;
    @BeforeEach
    public void setUp(){
        field = new Field("Rila", 1);
        mushroom = new Mushroom("Boletus", "nutty flavor", true, 0);
    }

    @Test
    public void createMushroomTest(){
        Assertions.assertEquals("Boletus", mushroom.getName());
        Assertions.assertEquals("nutty flavor", mushroom.getFlavor());
        Assertions.assertEquals(0, mushroom.getToxicity());
        Assertions.assertTrue(mushroom.isEdible());
    }

    @Test
    public void createFieldWithNameNull(){
        Assertions.assertThrows(NullPointerException.class, () -> {
            field = new Field(null, 10);
        });
    }

    @Test
    public void createFieldWithNegativeCapacity(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            field = new Field("New Field", -1);
        });
    }

    @Test
    public void testAddMushroomWithoutEnoughCapacity(){
        field.addMushroom(mushroom);

        Mushroom newMushroom = new Mushroom("field mushroom","nutty flavor", true, 0 );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            field.addMushroom(newMushroom);
        });
    }

    @Test
    public void testAddExistingMushroom(){
        field.addMushroom(mushroom);
        field.setCapacity(10);

        Mushroom newMushroom = new Mushroom("Boletus","nutty flavor", true, 0 );
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            field.addMushroom(newMushroom);
        });
    }

    @Test
    public void testRemoveMushroom(){

        field.addMushroom(mushroom);
        Assertions.assertEquals(1, field.getCount());

        field.removeMushroom("Boletus");

        Assertions.assertEquals(0, field.getCount());
    }


    @Test
    public void testGetMostPoisonousMushroom(){
        field.setCapacity(10);
        field.addMushroom(mushroom);
        Mushroom redFlyAgaric = new Mushroom("red fly agaric", "n/a", false, 10);
        Mushroom devilsMushroom = new Mushroom("devils Mushroom", "n/a", false, 5);
        field.addMushroom(redFlyAgaric);
        field.addMushroom(devilsMushroom);

        Assertions.assertEquals("red fly agaric", field.getMostPoisonousMushroom());
    }

    @Test
    public void testGetInEdibleMushrooms(){
        field.setCapacity(10);
        field.addMushroom(mushroom);
        Mushroom redFlyAgaric = new Mushroom("red fly agaric", "n/a", false, 10);
        Mushroom devilsMushroom = new Mushroom("devils Mushroom", "n/a", false, 5);

        List<Mushroom> inEdibleMushrooms = new ArrayList<>();
        inEdibleMushrooms.add(redFlyAgaric);
        inEdibleMushrooms.add(devilsMushroom);
        field.addMushroom(redFlyAgaric);
        field.addMushroom(devilsMushroom);

        Assertions.assertEquals(inEdibleMushrooms, field.getInedibleMushrooms());
    }

    @Test
    public void testGetMushroomsByFlavor(){
        field.setCapacity(10);
        field.addMushroom(mushroom);
        Mushroom redFlyAgaric = new Mushroom("red fly agaric", "n/a", false, 10);
        Mushroom devilsMushroom = new Mushroom("devils Mushroom", "n/a", false, 5);

        List<Mushroom> mushroomsWithFlavorNA = new ArrayList<>();
        mushroomsWithFlavorNA.add(redFlyAgaric);
        mushroomsWithFlavorNA.add(devilsMushroom);
        field.addMushroom(redFlyAgaric);
        field.addMushroom(devilsMushroom);

        Assertions.assertEquals(mushroomsWithFlavorNA, field.getMushroomsByFlavor("n/a"));
    }

    @Test
    public void testGetAllMushrooms(){
        field.setCapacity(10);
        field.addMushroom(mushroom);
        Mushroom redFlyAgaric = new Mushroom("red fly agaric", "n/a", false, 10);
        Mushroom devilsMushroom = new Mushroom("devils Mushroom", "n/a", false, 5);
        field.addMushroom(redFlyAgaric);
        field.addMushroom(devilsMushroom);


        Assertions.assertEquals(redFlyAgaric, field.getMushroom("red fly agaric"));
    }

    @Test
    public void getNameTest(){
        field.addMushroom(mushroom);

        Assertions.assertEquals("Rila", field.getName());
    }



}
