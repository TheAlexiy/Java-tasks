import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;
public class task3 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(task3.class.getName());
        FileHandler fh;
        logger.setUseParentHandlers(false);
        try {
            fh = new FileHandler("/Users/Final/IdeaProjects/task3/log.csv");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter); //FileHandler отказался настраиваться, сохраняются логи только с последнего запуска программы
        }
        catch (SecurityException | IOException e) {
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
                logger.info("Wanna scoop up " + scoop + ". (Fail)");
            }
            else {
                System.out.println("Из бочки взято " + scoop + " литров воды. Успех.");
                logger.info("Wanna scoop up " + scoop + ". (Success)");
                currentAmount -= scoop;
                logger.info("Barrel currently holds " + currentAmount);
            }
        }
        else {
            if (a==2) {
                System.out.println("Сколько литров требуется добавить?");
                int fill = scan.nextInt();
                if ((currentAmount + fill) > barrelSize) {
                    System.out.println("Вода не поместится в бочке. Неудача.");
                    logger.info("Wanna fill up " + fill + ". (Fail)");
                }
                else {
                    System.out.println("В бочку добавлено " + fill + " литров воды. Успех.");
                    logger.info("Wanna fill up " + fill + ". (Success)");
                    currentAmount += fill;
                    logger.info("Barrel currently holds " + currentAmount);
                }
            }
            else {
                System.out.println("Взят неправильный параметр");
                logger.info("Parameters to run the program are wrong");
            }
        }
    }
}