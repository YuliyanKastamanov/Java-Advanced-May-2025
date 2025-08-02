package furnitureFactory.entities.factories;

import furnitureFactory.entities.workshops.Workshop;

import java.util.ArrayList;
import java.util.Collection;

import static furnitureFactory.common.ExceptionMessages.FACTORY_NAME_NULL_OR_EMPTY;

public class BaseFactory implements Factory{


    private String name;
    private Collection<Workshop> workshops;
    private Collection<Workshop> removedWorkshops;

    public BaseFactory(String name) {
        this.workshops = new ArrayList<>();
        this.removedWorkshops = new ArrayList<>();
        setName(name);
    }

    public void setName(String name) {
        if(name.trim().isEmpty()){
            throw new NullPointerException(FACTORY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addWorkshop(Workshop workshop) {
        this.workshops.add(workshop);
    }

    @Override
    public Collection<Workshop> getWorkshops() {
        return workshops;
    }

    @Override
    public Collection<Workshop> getRemovedWorkshops() {
        return removedWorkshops;
    }
}
