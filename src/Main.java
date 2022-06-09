import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int command = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (command != 0) {
            if(command == 1) {
                System.out.println("Выберите месяц");
                int month = scanner.nextInt();
                System.out.println("Выберите день");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов");
                int step = scanner.nextInt();
                System.out.println("Всего пройдено в месяц  " + month + " день  " + day + " - " + stepTracker.addStep(month,day,step) + " шагов");
            } else if (command == 2) {
                System.out.println("Выберите месяц");
                int month = scanner.nextInt();
                stepTracker.printStat(month);
                System.out.println("Сумма шагов за " + month + " месяц:" + stepTracker.findSumStep(month));
                System.out.println("Максимальное количество шагов в " + month + "-ый месяц - " + stepTracker.findMaxStep(month));
                System.out.println("Среднее значение шагов в " + month + "-ый месяц - " + stepTracker.findAverageStep(month));
                System.out.println("Пройденая дистанция в " + month + "-ый месяц - " + stepTracker.findDistance(month) + " км.");
                System.out.println("Соженные каллории в " + month + "-ый месяц - " + stepTracker.findCalories(month) + " килокалорий");
                System.out.println("Лучшая серия за " + month + " месяц:" + stepTracker.findSeriesOfSteps(month) + " дней.");
            } else if (command == 3) {
                System.out.println("Введите новое целевое количество шагов в день.");
                int stepdaygoalnew = scanner.nextInt();
                System.out.println("Целевое количество шагов за день: " + stepTracker.changeStepgoal(stepdaygoalnew));
            } else {
                System.out.println("Такой команды нет");
            }
            printMenu();
            command = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход");
    }
}

