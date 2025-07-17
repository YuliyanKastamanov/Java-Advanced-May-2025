package OOP.ExamPrep.ElectricCarCompetition.core;

public interface Controller {


    String addDestination(String destinationType, String destinationName);
    String addCar(String destinationName, String carBrand, String carModel);
    String reachDestination(String destinationName);
    String getStatistics();
}
