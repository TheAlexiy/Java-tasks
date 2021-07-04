import java.math.BigInteger;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число");
        String a = scan.nextLine();
        System.out.println("Введите исходную систему счисления (Например, «01» - двоичная, «012» - троичная, " +
                "«0123456789abcdef» - шеснадцатиричная)");
        String b = scan.nextLine();
        if (check(a, b)) {
            System.out.println("Введите конечную систему счисления");
            String c = scan.nextLine();
            System.out.println("Результат перевода");
            if (b.equals("0123456789")) {
                int nb = Integer.parseInt(a);
                System.out.println(func(nb, c));
            }
            else System.out.println(func(a, b, c));
        }
        else System.out.println("Число невозможно представить в данной системе счисления");
    }
    public static String func(int number, String toBase) {
        int radix = toBase.length();
        BigInteger a = new BigInteger(String.valueOf(number));
        return a.toString(radix);
    }
    public static String func(String number, String base, String toBase) {
        int radix1 = base.length();
        int radix2 = toBase.length();
        BigInteger a = new BigInteger(String.valueOf(number), radix1);
        return a.toString(radix2);
    }
    public static boolean check(String number, String toBase) {
        String[] array = number.split("");
        boolean result = false;
        for (String s : array) {
            if (toBase.contains(s)) result = true;
            else {
                result = false;
                break;
            }
        }
        return result;
    }
}
