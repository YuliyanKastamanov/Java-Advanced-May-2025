package L10_Exam_Preparation_13_06.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void setFishInPool(List<Fish> fishInPool) {
        this.fishInPool = fishInPool;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(Fish fish){
        //1. Добавяме рибката ако нямаме друга така със същото ме
        //2. Добавяме рибката ако имаме капацитет
        Fish foundFishByName = findFish(fish.getName());
        if(foundFishByName == null && fishInPool.size() < capacity){
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name){
        Fish fishToRemove = findFish(name);
        return fishInPool.remove(fishToRemove);
    }

    public Fish findFish(String name) {
        Fish fishToReturn = null;

        for (Fish fish : fishInPool){
            if(fish.getName().equals(name)){
                fishToReturn = fish;
                break;
            }
        }
        return fishToReturn;
    }

    public String report(){
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("Aquarium: %s ^ Size: %d%n", name, size));

        for (Fish fish : fishInPool){
            builder.append(fish.toString()).append(System.lineSeparator());
        }
        return builder.toString();
    }
}
