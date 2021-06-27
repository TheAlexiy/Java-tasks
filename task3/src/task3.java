import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task3 {
    public static void main(String[] args) {
        String csvFile = "/Users/Final/IdeaProjects/task3/log.csv";
        String line;
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] country = line.split(cvsSplitBy);
                System.out.println("Country [code= " + country[4] + " , name = " + country[5] + "]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int barrelSize = 200;
        int currentAmount = 32;
        System.out.println("Зачерпнуть(1) воды или добавить(2)?");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if (a == 1) {
            System.out.println("Сколько литров требуется взять?");
            int scoop = scan.nextInt();
            if ((currentAmount - scoop) < 0) {
                System.out.println("Недостаточно воды в бочке. Неудача.");
            }
            else {
                System.out.println("Из бочки взято " + scoop + " литров воды. Успех.");
                currentAmount -= scoop;
            }
        }
        else {
            if (a==2) {
                System.out.println("Сколько литров требуется добавить?");
                int fill = scan.nextInt();
                if ((currentAmount + fill) > barrelSize) {
                    System.out.println("Вода не поместится в бочке. Неудача.");
                }
                else {
                    System.out.println("В бочку добавлено " + fill + " литров воды. Успех.");
                    currentAmount += fill;
                }
            }
            else {
                System.out.println("Взят неправильный параметр");
            }
        }
    }
}