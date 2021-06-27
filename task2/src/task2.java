public class task2 {
    public static void main(String[] args) {
        double x1 = 1;
        double y1 = 1;
        double z1 = 0;
        double x2 = 1;
        double y2 = 0;
        double z2 = 0;
        double xc = 0;
        double yc = 0;
        double zc = 0;
        double r = 1;
        double a = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2);
        double b = -2 * ((x2 - x1) * (xc - x1) + (y2 - y1) * (yc - y1) + (zc - z1) * (z2 - z1));
        double c = Math.pow(xc - x1, 2) + Math.pow(yc - y1, 2) + Math.pow(zc - z1, 2) - Math.pow(r, 2);
        double D = b * b - 4 * a * c;
        if (D < 0) {
            System.out.println("Коллизий нет");
        } else {
            if (D == 0) {
                double t = -b / (2 * a);
                double xt = x1 + (x2 - x1) * t;
                double yt = y1 + (y2 - y1) * t;
                double zt = z1 + (z2 - z1) * t;
                System.out.println("1 точка соприкосновения с координатами {" + xt + "," + yt + "," + zt + "}");
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
                System.out.println("2 точки соприкосновения с координатами {" + xt1 + "," + yt1 + "," + zt1 + "} и {" + xt2 + "," + yt2 + "," + zt2 + "}");
            }
        }
    }
}
