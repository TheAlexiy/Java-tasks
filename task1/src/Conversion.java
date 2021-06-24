import java.math.BigInteger;
import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число");
        int a = scan.nextInt();
        System.out.println("Введите исходную систему счисления");
        int b = scan.nextInt();
        System.out.println("Введите конечную систему счисления");
        int c = scan.nextInt();
        if ((b<2)|(c<2)) {
            System.out.println("Ситстема счисления выбрана некорректно");
            System.exit(0);
        }
        System.out.println("Результат перевода");
        if (b == 10) {
            System.out.println(Func(a,c));
        }
        else {
            System.out.println(Func(a,b,c));
        }
    }
    public static String Func(int number, int radixFinal) {
        BigInteger a= new BigInteger(String.valueOf(number));
        return a.toString(radixFinal);
    }
    public static String Func(int number, int radixBase, int radixFinal) {
        BigInteger a= new BigInteger(String.valueOf(number), radixBase);
        return a.toString(radixFinal);
    }
}