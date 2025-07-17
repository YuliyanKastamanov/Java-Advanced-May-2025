package OOP.ExamPrep.ElectricCarCompetition.entities.destination;


import competition.common.ExceptionMessages;
import competition.entities.car.Car;

import java.util.ArrayList;
import java.util.Collection;


public class BaseDestination implements Destination{


    private String name;
    private int distance;

    //should be Collection
    private Collection<Car> cars;

    public BaseDestination(String name, int distance) {
        this.cars = new ArrayList<>();
        this.setName(name);
        this.setDistance(distance);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.DESTINATION_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        if(distance < 0){
            throw new IllegalArgumentException(ExceptionMessages.NEGATIVE_DISTANCE_VALUE);
        }
        this.distance = distance;
    }

    @Override
    public Collection<Car> getCars() {
        return cars;
    }


}
