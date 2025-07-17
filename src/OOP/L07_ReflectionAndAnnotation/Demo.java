package L07_ReflectionAndAnnotation;

import java.lang.reflect.*;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //Достъп до клас
        Class animalClass = Animal.class;

        System.out.println(animalClass.getSimpleName());

        //Достъп до конструкторите
        Constructor[] constructors = animalClass.getConstructors();
        System.out.println();

        //Достъп до конкретен конструктор
        Constructor<Animal> constructor = animalClass.getConstructor(String.class, int.class);


        Animal pepaPig = constructor.newInstance("Pepa", 2);

        Animal rex = constructor.newInstance("Rex", 3);

        System.out.println();

        //достъп до полета
        Field nameField = animalClass.getDeclaredField("name");//ще получим всички публични полета
        Field[] allFields = animalClass.getDeclaredFields();// връща всички полета
        System.out.println();

        //достъп до методи
        Method[] allMethods = animalClass.getDeclaredMethods();//всички методи
        Method[] publicMethods = animalClass.getMethods();//публичните методи
        Arrays.stream(allMethods).forEach(method -> {
            System.out.println(method.getName());
        });

        Method getNameMethod = animalClass.getDeclaredMethod("getName");
        getNameMethod.setAccessible(true);

        System.out.println(getNameMethod.invoke(pepaPig));
        System.out.println(getNameMethod.invoke(rex));

        //всеки аксес модифайър -> mask
        int mask = nameField.getModifiers();
        System.out.println(mask);

        for (Field field : allFields){
            field.setAccessible(true);
            System.out.println(Modifier.toString(field.getModifiers()));
        }

    }
}
