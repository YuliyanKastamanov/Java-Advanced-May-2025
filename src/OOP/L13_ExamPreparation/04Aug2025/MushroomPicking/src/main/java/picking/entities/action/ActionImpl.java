package picking.entities.action;

import picking.entities.pickers.Picker;
import picking.entities.places.Place;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ActionImpl implements Action{
    @Override
    public void startPicking(Place place) {

        Collection<String> mushrooms = place.getMushrooms();
        List<Picker> pickers = new ArrayList<>(place.getPickers());

        for (Picker picker : pickers){
            while (picker.getVitality() > 0 && mushrooms.iterator().hasNext()){

                String currentMushroom = mushrooms.iterator().next();
                picker.pick();

                if(currentMushroom.startsWith("poisonous")){
                    picker.getBag().getMushrooms().clear();
                }else {
                    picker.getBag().getMushrooms().add(currentMushroom);
                }
                mushrooms.remove(currentMushroom);

            }
        }



    }
}
