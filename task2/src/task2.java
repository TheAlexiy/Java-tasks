public class task2 {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder();
        for (String arg : args) s.append(arg);
        int i1 = s.indexOf("center:");
        int i2 = s.indexOf("radius:");
        int i3 = s.indexOf("line:");
        if (i1 < i3) {
            String center = s.substring(s.indexOf("[", i1) + 1, s.indexOf("]", i1));
            String[] array1 = center.split(",");
            String r = s.substring(s.indexOf(":", i2) + 1, s.indexOf(check(i1,i2), i2));
            String line1 = s.substring(s.indexOf("[", i3) + 1, s.indexOf("]", i3));
            String[] array2 = line1.split(",");
            String line2 = s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"));
            String[] array3 = line2.split(",");
            Solution(array1,array2,array3,r);
        } else {
            String line1 = s.substring(s.indexOf("[", i3) + 1, s.indexOf("]", i3));
            String[] array2 = line1.split(",");
            String line2 = s.substring(s.indexOf("],[", i3) + 3, s.indexOf("]}", i3));
            String[] array3 = line2.split(",");
            String r = s.substring(s.indexOf(":", i2) + 1, s.indexOf(check(i1,i2), i2));
            String center = s.substring(s.lastIndexOf("[") + 1, s.lastIndexOf("]"));
            String[] array1 = center.split(",");
            Solution(array1,array2,array3,r);
        }
    }
    public static void Solution(String[] array1,String[] array2,String [] array3,String radius) {
        double x1 = Double.parseDouble(array2[0]);
        double y1 = Double.parseDouble(array2[1]);
        double z1 = Double.parseDouble(array2[2]);
        double x2 = Double.parseDouble(array3[0]);
        double y2 = Double.parseDouble(array3[1]);
        double z2 = Double.parseDouble(array3[2]);
        double xc = Double.parseDouble(array1[0]);
        double yc = Double.parseDouble(array1[1]);
        double zc = Double.parseDouble(array1[2]);
        double r = Double.parseDouble(radius);
        double a = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2);
        double b = -2 * ((x2 - x1) * (xc - x1) + (y2 - y1) * (yc - y1) + (zc - z1) * (z2 - z1));
        double c = Math.pow(xc - x1, 2) + Math.pow(yc - y1, 2) + Math.pow(zc - z1, 2) - Math.pow(r, 2);
        double D = b * b - 4 * a * c;
        if (D < 0) {
            System.out.println("\nКоллизий нет");
        } else {
            if (D == 0) {
                double t = -b / (2 * a);
                double xt = x1 + (x2 - x1) * t;
                double yt = y1 + (y2 - y1) * t;
                double zt = z1 + (z2 - z1) * t;
                System.out.println("\n" + "1 точка соприкосновения с координатами {" + xt + ", " + yt + ", " + zt + "}");
            } else {
                double sqrt = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
                double t1 = (-b + sqrt) / (2 * a);
                double t2 = (-b - sqrt) / (2 * a);
                double xt1 = x1 + (x2 - x1) * t1;
                double yt1 = y1 + (y2 - y1) * t1;
                double zt1 = z1 + (z2 - z1) * t1;
                double xt2 = x1 + (x2 - x1) * t2;
                double yt2 = y1 + (y2 - y1) * t2;
                double zt2 = z1 + (z2 - z1) * t2;
                System.out.println("\n" + "2 точки соприкосновения: \nПервая точка с координатами {" + xt1 + ", " + yt1 + ", " + zt1 + "} " +
                        "\nВторая точка с координатами {" + xt2 + ", " + yt2 + ", " + zt2 + "}");
            }
        }
    }
    public static String check(int i1, int i2) {
        if (i1 > i2) return ",";
        else return "}";
    }
}









