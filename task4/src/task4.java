import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите первую строку");
        String a = scan.nextLine();
        System.out.println("Введите вторую строку");
        String b = scan.nextLine();
        String s = b.replaceAll("\\*+", ".*");
        if ((a.matches(s))) {
            System.out.println("OK");
        }
        else {
            System.out.println("KO");
        }
    }
}