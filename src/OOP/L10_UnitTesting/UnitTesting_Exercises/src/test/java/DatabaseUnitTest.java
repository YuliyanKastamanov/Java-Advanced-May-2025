import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseUnitTest {

    /*private Database database;
    private Integer[] elements;

    @BeforeEach
    void setUp() throws OperationNotSupportedException {
        elements = new Integer[]{10, 20, 30};
        database = new Database(elements);
    }*/


    //1. Тестваме само един сценарий
    //2. Имената на тестовете(методите) трябва да бъдат описателни, за да знаем какво сме тествали

    @Test
    public void whenCreateDatabaseWithZeroElements_thenExceptionIsThrown(){

        Integer[] zeroElementsArray = new Integer[0];

        //assertThrows = очаквам даден код да хвърли exception
        // 1-во -> трябва да запишем от кой клас ще бъде грешката -> OperationNotSupportedException
        // 2-ро -> () -> {кода, който хвърля тази грешка}

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            Database database = new Database(zeroElementsArray);
        });
    }

    @Test
    public void whenCreateDatabaseWithMoreThanSixteenElements_thenExceptionIsThrown(){
        //Масив с повече от 16 елемента
        Integer[] arrayWithMoreThanAllowedElements = new Integer[17];

        //Очаквам, че няма да мога да създам база от данни с повече от 16 елемента -> OperationNotSupportedException
        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            Database database = new Database(arrayWithMoreThanAllowedElements);
        });
    }

    @Test
    public void whenCreateDatabaseWithAllowedNumberOfElements_thenDatabaseShouldBeSuccessfullyCreated() throws OperationNotSupportedException {

        Integer[] elements = new Integer[]{10, 20, 30};
        Database database = new Database(elements);

        int arrayElementIndexZero = elements[0];
        int databaseElementIndexZero = database.getElements()[0];

        //AssertEquals(expected, actual)

        Assertions.assertEquals(arrayElementIndexZero, databaseElementIndexZero);
        Assertions.assertEquals(elements[1], database.getElements()[1]);
        Assertions.assertEquals(elements[2], database.getElements()[2]);
        Assertions.assertEquals(elements.length, database.getElements().length);


    }

    @Test
    public void whenAddElementToDatabase_thenElementSuccessfullyAddedAndCountShouldBeIncrementedByOne() throws OperationNotSupportedException {

        Integer numberToAdd = 40;
        Integer[] elements = new Integer[]{10, 20, 30};
        Database database = new Database(elements);

        int databaseInitialCountElements = database.getElements().length;

        database.add(numberToAdd);

        //След добавяне на елемента очаквам:
        //1. Последния елемент да бъде числото, което добавям -> 40
        int lastElement = database.getElements()[database.getElements().length - 1]; // 40
        Assertions.assertEquals(lastElement, numberToAdd);

        //2. Броят на елементи в database да се увеличи с 1
        int databaseCountAfterAddingElement = database.getElements().length;
        Assertions.assertEquals(databaseCountAfterAddingElement, databaseInitialCountElements + 1);


    }

    @Test
    public void whenAddNullElementToDatabase_thenExceptionIsThrown() throws OperationNotSupportedException {

        Integer[] elements = new Integer[]{10, 20, 30};
        Database database = new Database(elements);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.add(null);
        });

    }

    @Test
    public void whenRemoveElementFromDatabaseWithManyElements_thenElementSuccessfullyRemovedAndCountDecrementedByOne() throws OperationNotSupportedException {
        Integer[] elements = new Integer[]{10, 20, 30};
        Database database = new Database(elements);

        int oldDatabaseCount = database.getElements().length;

        database.remove();

        int expectedDatabaseCount = database.getElements().length;

        Assertions.assertEquals(expectedDatabaseCount, oldDatabaseCount - 1);

    }

    @Test
    public void whenRemoveElementFromDatabase_thenExceptionIsThrown() throws OperationNotSupportedException {
        Integer[] elements = new Integer[]{10};
        Database database = new Database(elements);

        database.remove();

        Assertions.assertThrows(OperationNotSupportedException.class, database::remove);
    }


}
