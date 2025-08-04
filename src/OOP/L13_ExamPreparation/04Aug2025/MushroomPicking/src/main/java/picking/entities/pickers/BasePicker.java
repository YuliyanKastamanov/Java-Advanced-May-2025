package picking.entities.pickers;

import picking.common.ExceptionMessages;
import picking.entities.bag.Bag;
import picking.entities.bag.BagImpl;

public class BasePicker implements Picker{


    private String name;
    private int vitality;
    private Bag bag;

    public BasePicker(String name, int vitality) {
        setName(name);
        setVitality(vitality);
        this.bag = new BagImpl();
    }



    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(ExceptionMessages.PICKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setVitality(int vitality) {
        if(vitality < 0){
            throw new IllegalArgumentException(ExceptionMessages.PICKER_VITALITY_LESS_THAN_ZERO);
        }
        this.vitality = vitality;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getVitality() {
        return vitality;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    @Override
    public void pick() {
        this.vitality -= 10;
        if(this.vitality < 0){
            setVitality(0);
        }
    }
}
