public class StepTracker {

    int stepDayGoal;
    MonthData[] monthToData;
    Converter converter = new Converter();

    public StepTracker(int stepDayGoal) {
        this.stepDayGoal = stepDayGoal;
        monthToData = new MonthData[12];

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    int addStep(int month, int day, int step) {
        if (step < 0) {
            System.out.println("Ошибка! Вы ввели отрицательное значение!");
        } else {
            monthToData[month].dayOfMonth[day] = step;
        }
        return monthToData[month].dayOfMonth[day];
    }

    int findSumStep(int month) {
        int sumOfMonth = 0;
        for (int i = 0; i < monthToData[month].dayOfMonth.length; i++) {
            sumOfMonth += monthToData[month].dayOfMonth[i];
        }
        return sumOfMonth;
    }

    void printStat(int month) {
        for (int i = 0; i < monthToData[month].dayOfMonth.length; i++) {
            System.out.println(i + " день: " + monthToData[month].dayOfMonth[i] + "  ");
        }
    }

    int findMaxStep(int month) {
        int maxStep = 0;
        for (int i = 0; i < monthToData[month].dayOfMonth.length; i++) {
            if (monthToData[month].dayOfMonth[i] > maxStep) {
                maxStep = monthToData[month].dayOfMonth[i];
            }
        }
        return maxStep;
    }

    int findAverageStep(int month) {
        int sum = 0;
        for (int i = 0; i < monthToData[month].dayOfMonth.length; i++) {
            sum += monthToData[month].dayOfMonth[i];
        }
        return sum / monthToData[month].dayOfMonth.length;
    }

    int changeStepGoal(int stepDayGoalNew) {
        if (stepDayGoalNew > 0) {
            stepDayGoal = stepDayGoalNew;
        } else {
            System.out.println("Вы ввели отрицательное значение, целевое количество шагов остается неизмененным");
        }
        return stepDayGoal;
    }

    double findDistance(int month) {
        double sumOfMonth = 0;
        for (int i = 0; i < monthToData[month].dayOfMonth.length; i++) {
            sumOfMonth += monthToData[month].dayOfMonth[i];
        }
        return converter.convertDistance(sumOfMonth);
    }

    double findCalories(int month) {
        double sumOfMonth = 0;
        for (int i = 0; i < monthToData[month].dayOfMonth.length; i++) {
            sumOfMonth += monthToData[month].dayOfMonth[i];
        }
        return converter.convertCalories(sumOfMonth);
    }

    int findSeriesOfSteps(int month) {
        int count = 0;
        int countMax = 0;

        for (int i = 0; i < monthToData[month].dayOfMonth.length; i++) {
            if (monthToData[month].dayOfMonth[i] >= stepDayGoal) {
                count += 1;
            } else {
                if(countMax < count) {
                    countMax = count;
                    count = 0;
                }
            }
        }
        return countMax;
    }

    class MonthData {
        int[] dayOfMonth;

        MonthData() {
            dayOfMonth = new int[30];
            for (int i = 0; i < dayOfMonth.length; i++) {
            }
        }
    }
}



