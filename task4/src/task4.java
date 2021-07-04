public class task4 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for (String arg : args) s.append(arg);
        int index1 = s.indexOf("Первая строка:");
        int index2 = s.indexOf(",");
        String str1 = s.substring(s.indexOf("'",index1) + 1, s.indexOf(",",index1)-1);
        System.out.println(str1);
        String str2 = s.substring(s.indexOf("'",index2) + 1, s.indexOf(".",index2)-1);
        System.out.println(str2);
        String sub = str2.replaceAll("\\*+", ".*");
        if ((str1.matches(sub))) {
            System.out.println("OK");
        }
        else {
            System.out.println("KO");
        }
    }
}