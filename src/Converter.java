public class Converter {

    double dimstep = 75;
    double calories = 50;



    public Converter(){

    }

    double convertDistance (double step){
        double totaldistance = 0;
        totaldistance = step * (dimstep / 100000);
        return totaldistance;
    }

    double convertCalories(double step){
        double totalcalories = 0;
        totalcalories = step * (calories / 1000);
        return totalcalories;
    }


}
