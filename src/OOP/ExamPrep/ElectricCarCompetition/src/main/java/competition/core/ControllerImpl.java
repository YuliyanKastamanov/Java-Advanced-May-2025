package competition.core;

//TODO - Implement all the methods

import competition.common.ConstantMessages;
import competition.common.ExceptionMessages;
import competition.entities.car.*;
import competition.entities.competition.Competition;
import competition.entities.competition.CompetitionImpl;
import competition.entities.destination.Destination;
import competition.entities.destination.Lake;
import competition.entities.destination.Mountain;
import competition.entities.destination.SeaSide;
import competition.entities.repositories.DestinationRepository;
import competition.entities.repositories.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private final Repository<Destination> destinationRepository;

    public ControllerImpl() {
        this.destinationRepository = new DestinationRepository();
    }


    @Override
    public String addDestination(String destinationType, String destinationName) {

        //създаваме си дестинацията
        Destination destinationToAdd;
        switch (destinationType){
            case "Mountain" -> destinationToAdd = new Mountain(destinationName);
            case "SeaSide" -> destinationToAdd = new SeaSide(destinationName);
            case "Lake" -> destinationToAdd = new Lake(destinationName);
            default -> throw new  IllegalArgumentException(ExceptionMessages.INVALID_DESTINATION);
        }

        //проверяваме дали съществува дестинация с такова име в destinationRepository
        Destination checkExistingDestination = destinationRepository.byName(destinationName);
        if(checkExistingDestination != null){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_DESTINATION);
        }

        //добавяме новата дестинация в destinationRepository и връщаме съобщение
        destinationRepository.add(destinationToAdd);
        return String.format(ConstantMessages.DESTINATION_ADDED, destinationType, destinationName);
    }

    @Override
    public String addCar(String destinationName, String carBrand, String carModel) {
        //създаваме си дестинация на база име на дестинация
        Destination destination = destinationRepository.byName(destinationName);
        //ако нямаме такава дестинация хвърляме ексепшън
        if(destination == null){
            throw new NullPointerException(ExceptionMessages.NON_EXISTING_DESTINATION);
        }

        //намираме дали колата ни съществува с посочения модел
        Car carByModel = destination.getCars().stream()
                .filter(car -> car.getModel().equals(carModel))
                .findFirst().orElse(null);

        //ако колата съществува хвърлям ексепшън
        if(carByModel != null){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_CAR_BRAND_AND_MODEL);
        }

        Car carToAdd;
        //Създаваме колата на базата на бранд-а, ако такъв бранд не съществува хвърляме ексепшън
        switch (carBrand){
            case "Dacia" ->  carToAdd = new Dacia(carModel);
            case "Hyundai" ->  carToAdd = new Hyundai(carModel);
            case "Tesla" ->  carToAdd = new Tesla(carModel);
            case "VW" ->  carToAdd = new VW(carModel);
            default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_CAR);

        }
        //добавяме колата към вече създадения списък с коли
        destination.getCars().add(carToAdd);

        return String.format(ConstantMessages.CAR_ADDED, carBrand, carModel);
    }

    @Override
    public String reachDestination(String destinationName) {

        Destination destination = destinationRepository.byName(destinationName);
        Collection<Car> cars = destination.getCars();

        Competition competition = new CompetitionImpl();
        competition.startVoyage(destination, cars);
        List<Car> unFinishedCars = getUnfinishedCars(destination);

        return String.format(ConstantMessages.VOYAGE_OVER, destinationName, unFinishedCars.size());
    }

    private List<Car> getUnfinishedCars(Destination destination) {

        return destination.getCars().stream()
                .filter(car ->
                        (car.getMileage() < destination.getDistance()
                                && car.getBatteryCapacity() < 15))
                .collect(Collectors.toList());
    }


    @Override
    public String getStatistics() {
        StringBuilder builder = new StringBuilder();

        Collection<Destination> destinations = destinationRepository.getCollection();

        for (Destination currentDestination : destinations){
            builder
                    .append(String.format(ConstantMessages.CARS_TOOK_PART, currentDestination.getName()))
                    .append(System.lineSeparator());
            for (Car car : currentDestination.getCars()){
                extractCarInfo(car, builder);
            }
        }


        return builder.toString();
    }

    private void extractCarInfo(Car car, StringBuilder builder) {
        builder.append(String.format(ConstantMessages.FINAL_CAR_INFO,
                car.getClass().getSimpleName(),
                car.getModel(),
                car.getBatteryCapacity(),
                car.getMileage()))
                .append(System.lineSeparator());

    }
}
