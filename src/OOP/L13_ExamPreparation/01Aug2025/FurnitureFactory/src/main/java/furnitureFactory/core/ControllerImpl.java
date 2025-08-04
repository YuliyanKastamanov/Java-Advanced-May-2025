package furnitureFactory.core;

import furnitureFactory.common.ConstantMessages;
import furnitureFactory.common.ExceptionMessages;
import furnitureFactory.entities.factories.AdvancedFactory;
import furnitureFactory.entities.factories.Factory;
import furnitureFactory.entities.factories.OrdinaryFactory;
import furnitureFactory.entities.wood.OakWood;
import furnitureFactory.entities.wood.Wood;
import furnitureFactory.entities.workshops.DeckingWorkshop;
import furnitureFactory.entities.workshops.TableWorkshop;
import furnitureFactory.entities.workshops.Workshop;
import furnitureFactory.repositories.WoodRepository;
import furnitureFactory.repositories.WoodRepositoryImpl;
import furnitureFactory.repositories.WorkshopRepository;
import furnitureFactory.repositories.WorkshopRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static furnitureFactory.common.ExceptionMessages.INSUFFICIENT_WOOD;

public class ControllerImpl implements Controller {

    private WoodRepository woodRepository;
    private WorkshopRepository workshopRepository;
    private Collection<Factory> factories;

    public ControllerImpl() {
        this.woodRepository = new WoodRepositoryImpl();
        this.workshopRepository = new WorkshopRepositoryImpl();
        this.factories = new ArrayList<>();
    }

    //TODO Implement all the methods
    @Override
    public String buildFactory(String factoryType, String factoryName) {
        if(!(factoryType.equals("OrdinaryFactory") || factoryType.equals("AdvancedFactory"))){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FACTORY_TYPE);
        }

        Factory factoryByName = getFactoryByName(factoryName);

        if(factoryByName != null){
            throw new NullPointerException(ExceptionMessages.FACTORY_EXISTS);
        }

        Factory factoryToBuild = null;
        switch (factoryType){
            case "OrdinaryFactory" -> factoryToBuild = new OrdinaryFactory(factoryName);
            case "AdvancedFactory" -> factoryToBuild = new AdvancedFactory(factoryName);
        }
        factories.add(factoryToBuild);
        return String.format(ConstantMessages.SUCCESSFULLY_BUILD_FACTORY_TYPE, factoryType, factoryName);
    }

    @Override
    public Factory getFactoryByName(String factoryName) {

        return factories.stream()
                .filter(factory -> factory.getName().equals(factoryName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String buildWorkshop(String workshopType, int woodCapacity) {
        Workshop workshop;
        switch (workshopType){
            case "TableWorkshop" -> workshop = new TableWorkshop(woodCapacity);
            case "DeckingWorkshop" -> workshop = new DeckingWorkshop(woodCapacity);
            default -> throw new IllegalArgumentException(ExceptionMessages.INVALID_WORKSHOP_TYPE);
        }
        workshopRepository.add(workshop);
        return String.format(ConstantMessages.SUCCESSFULLY_BUILD_WORKSHOP_TYPE, workshopType);
    }

    @Override
    public String addWorkshopToFactory(String factoryName, String workshopType) {
        Factory factory = getFactoryByName(factoryName);
        Workshop workshop = workshopRepository.findByType(workshopType);

        if(workshop == null){
            throw new NullPointerException(String.format(ExceptionMessages.NO_WORKSHOP_FOUND,workshopType));
        }

        if (factory.getWorkshops().contains(workshop)) {
            throw new IllegalArgumentException(ExceptionMessages.WORKSHOP_EXISTS);
        }

        if(factory.getClass().getSimpleName().equals("OrdinaryFactory") &&
                workshop.getClass().getSimpleName().equals("TableWorkshop")){
            factory.addWorkshop(workshop);
        }else if(factory.getClass().getSimpleName().equals("AdvancedFactory") &&
                workshop.getClass().getSimpleName().equals("DeckingWorkshop")) {
            factory.addWorkshop(workshop);

        }else {
            return ExceptionMessages.NON_SUPPORTED_WORKSHOP;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_WORKSHOP_IN_FACTORY, workshopType, factoryName);
    }


    @Override
    public String buyWoodForFactory(String woodType) {

        if(!woodType.equals("OakWood")){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_WOOD_TYPE);
        }

        Wood wood = new OakWood();
        woodRepository.add(wood);
        return String.format(ConstantMessages.SUCCESSFULLY_BOUGHT_WOOD_FOR_FACTORY, woodType);
    }

    @Override
    public String addWoodToWorkshop(String factoryName, String workshopType, String woodType) {
        Factory factory = getFactoryByName(factoryName);
        Workshop workshop = factory.getWorkshops().stream()
                .filter(w -> w.getClass().getSimpleName().equals(workshopType))
                .findFirst()
                .orElse(null);

        if(workshop == null){
            throw new NullPointerException(ExceptionMessages.NO_WORKSHOP_ADDED);
        }

        Wood wood = woodRepository.findByType(woodType);
        if(wood == null){
            throw new NullPointerException(String.format(ExceptionMessages.NO_WOOD_FOUND, woodType));
        }
        workshop.addWood(wood);
        woodRepository.remove(wood);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_WOOD_IN_WORKSHOP, woodType, workshopType);
    }

    @Override
    public String produceFurniture(String factoryName) {
        Factory factory = getFactoryByName(factoryName);

        int producedFurnitureCount = 0;

        if(factory.getWorkshops().isEmpty()){
            throw new NullPointerException(String.format(ExceptionMessages.THERE_ARE_NO_WORKSHOPS, factory.getName()));
        }
        Collection<Workshop> workshops = factory.getWorkshops();

        for (Workshop workshop : workshops){
            if(workshop.getWoodQuantity() <= 0){
                factory.getRemovedWorkshops().add(workshop);
                workshopRepository.remove(workshop);
                System.out.printf((ExceptionMessages.WORKSHOP_STOPPED_WORKING) + "%n", workshop.getClass().getSimpleName());
                break;
            } else if ( workshop.getWoodQuantity() < workshop.getWoodQuantityReduceFactor()) {
                System.out.println(INSUFFICIENT_WOOD);
                break;
            }
            workshop.produce();
            producedFurnitureCount++;
        }
        return producedFurnitureCount == 0 //ако имаме 0 произведени мебели
            ? String.format(ExceptionMessages.FACTORY_DO_NOT_PRODUCED, factory.getName())// не сме произвели мебели
            : String.format(ConstantMessages.SUCCESSFUL_PRODUCTION, producedFurnitureCount, factory.getName());
    }

    @Override
    public String getReport() {

        StringBuilder builder = new StringBuilder();
        for (Factory factory : factories){

            builder.append("Production by ").append(factory.getName()).append(" factory:\n");
            if(factory.getWorkshops().isEmpty() && factory.getRemovedWorkshops().isEmpty()){
                builder.append("No workshops were added to produce furniture.\n");
            }

            getAllWorkShopsInfo(factory.getWorkshops(), builder);
            getAllWorkShopsInfo(factory.getRemovedWorkshops(), builder);
        }
        return builder.toString().trim();
    }

    private void getAllWorkShopsInfo(Collection<Workshop> workshops, StringBuilder builder) {

        for (Workshop workshop : workshops){
            //получавахме 141 точки, заради изпуснат интервал
            builder.append(String.format("  %s: %d furniture produced\n",
                    workshop.getClass().getSimpleName(),
                    workshop.getProducedFurnitureCount()));
        }
    }
}
