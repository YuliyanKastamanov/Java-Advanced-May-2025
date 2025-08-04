package picking.repositories;

import picking.entities.places.Place;

import java.util.ArrayList;
import java.util.Collection;

public class PlaceRepository implements Repository<Place>{

    private Collection<Place> places;

    public PlaceRepository() {
        this.places = new ArrayList<>();
    }


    @Override
    public Collection<Place> getCollection() {
        return places;
    }

    @Override
    public void add(Place place) {
        places.add(place);

    }

    @Override
    public boolean remove(Place place) {
        return places.remove(place);
    }

    @Override
    public Place byName(String name) {
        return places.stream()
                .filter(place -> place.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
