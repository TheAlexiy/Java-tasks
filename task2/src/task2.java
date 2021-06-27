import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class task2 {
    public static void main(String[] args) {
        String csvFile = "/Users/Final/IdeaProjects/task2/log.csv";
        String line;
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] coord = line.split(cvsSplitBy);
                System.out.println("Координаты центра окружности: {" + coord[1] + "," + coord[2] + "," + coord[3] + "}");
                System.out.println("Радиус окружности: " + coord[6]);
                System.out.println("Координаты начала отрезка: {" + coord[9] + "," + coord[10] + "," + coord[11] + "}");
                System.out.println("Координаты конца отрезка: {" + coord[14] + "," + coord[15] + "," + coord[16] + "}");
                double x1 = Double.parseDouble(coord[9]);
                double y1 = Double.parseDouble(coord[10]);
                double z1 = Double.parseDouble(coord[11]);
                double x2 = Double.parseDouble(coord[14]);
                double y2 = Double.parseDouble(coord[15]);
                double z2 = Double.parseDouble(coord[16]);
                double xc = Double.parseDouble(coord[1]);
                double yc = Double.parseDouble(coord[2]);
                double zc = Double.parseDouble(coord[3]);
                double r = Double.parseDouble(coord[6]);
                double a = Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2);
                double b = -2 * ((x2 - x1) * (xc - x1) + (y2 - y1) * (yc - y1) + (zc - z1) * (z2 - z1));
                double c = Math.pow(xc - x1, 2) + Math.pow(yc - y1, 2) + Math.pow(zc - z1, 2) - Math.pow(r, 2);
                double D = b * b - 4 * a * c;
                if (D < 0) {
                    System.out.println("\n" + "Коллизий нет");
                } else {
                    if (D == 0) {
                        double t = -b / (2 * a);
                        double xt = x1 + (x2 - x1) * t;
                        double yt = y1 + (y2 - y1) * t;
                        double zt = z1 + (z2 - z1) * t;
                        System.out.println("\n" + "1 точка соприкосновения с координатами {" + xt + "," + yt + "," + zt + "}");
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
                        System.out.println("\n" + "2 точки соприкосновения с координатами {" + xt1 + "," + yt1 + "," + zt1 + "} и {" + xt2 + "," + yt2 + "," + zt2 + "}");
                    }
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
