import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
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
                System.out.println("Из бочки взято " + scoop + " воды. Успех.");
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
                    System.out.println("В бочку добавлено " + fill + " воды. Успех.");
                    currentAmount += fill;
                }
            }
            else {
                System.out.println("Взят неправильный параметр");
            }
        }
    }
}