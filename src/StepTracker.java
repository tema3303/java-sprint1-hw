public class StepTracker {

    int stepdaygoal = 10000;
    MonthData[] monthToData;
    Converter converter = new Converter();


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    class MonthData {
        int[] dayofmonth;

        MonthData() {
            dayofmonth = new int[30];
            for (int i = 0; i < dayofmonth.length; i++) {
            }
        }
    }


    int addStep(int month, int day, int step) {
        if (step < 0) {
            System.out.println("Ошибка! Вы ввели отрицательное значение!");
        } else {
            monthToData[month].dayofmonth[day] = step;
        }
        return monthToData[month].dayofmonth[day];

    }


    int findSumStep(int month) {
        int sumofmonth = 0;
        for (int i = 0; i < monthToData[month].dayofmonth.length; i++) {
            sumofmonth += monthToData[month].dayofmonth[i];
        }
        return sumofmonth;
    }

    void printStat(int month) {

        for (int i = 0; i < monthToData[month].dayofmonth.length; i++) {
            System.out.println(i + " день: " + monthToData[month].dayofmonth[i] + "  ");
        }
    }

    int findMaxStep(int month) {
        int maxstep = 0;
        for (int i = 0; i < monthToData[month].dayofmonth.length; i++) {
            if (monthToData[month].dayofmonth[i] > maxstep) {
                maxstep = monthToData[month].dayofmonth[i];
            }
        }
        return maxstep;
    }

    int findAverageStep(int month) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < monthToData[month].dayofmonth.length; i++) {
            sum += monthToData[month].dayofmonth[i];
            count = i + 1;
        }
        return sum / count;
    }

    int changeStepgoal(int stepdaygoalnew) {
        if (stepdaygoalnew > 0) {
            stepdaygoal = stepdaygoalnew;
        } else {
            System.out.println("Вы ввели отрицательное значение, целевое количество шагов остается неизмененным");
        }
        return stepdaygoal;
    }

    double findDistance(int month) {
        double sumofmonth = 0;
        double distance = 0;
        for (int i = 0; i < monthToData[month].dayofmonth.length; i++) {
            sumofmonth += monthToData[month].dayofmonth[i];
            distance = converter.convertDistance(sumofmonth);
        }
        return distance;
    }

    double findCalories(int month) {
        double sumofmonth = 0;
        for (int i = 0; i < monthToData[month].dayofmonth.length; i++) {
            sumofmonth += monthToData[month].dayofmonth[i];
        }
        return converter.convertCalories(sumofmonth);
    }

    int findSeriesOfSteps(int month) {
        int count = 0;
        int countmax = 0;

        for (int i = 0; i < monthToData[month].dayofmonth.length; i++) {
            if (monthToData[month].dayofmonth[i] >= stepdaygoal) {
                count += 1;
            } else {
                if(countmax < count) {
                    countmax = count;
                    count = 0;
                }
            }
        }
        return countmax;
    }
}



