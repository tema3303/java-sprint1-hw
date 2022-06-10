public class Converter {

    double dimStep = 75;
    double calories = 50;


    double convertDistance (double step){
        double totalDistance = step * (dimStep / 100000);
        return totalDistance;
    }

    double convertCalories(double step){
        double totalCalories = step * (calories / 1000);
        return totalCalories;
    }


}
