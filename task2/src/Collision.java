import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Collision {

    public static List<Point> getSphereLineIntersectionPoint(Point pointA, Point pointB, Point center, double radius) {
        double baX = pointB.x - pointA.x;
        double baY = pointB.y - pointA.y;
        double baZ = pointB.z - pointA.z;
        double caX = center.x - pointA.x;
        double caY = center.y - pointA.y;
        double caZ = center.z - pointA.z;

        double a = baX * baX + baY * baY + baZ * baZ;
        double bBy2 = baX * caX + baY * caY + baZ * caZ;
        double c = caX * caX + caY * caY + caZ * caZ - radius * radius;

        double pBy2 = bBy2 / a;
        double q = c / a;

        double disc = pBy2 * pBy2 - q;
        if (disc < 0) {
            System.out.println("Коллизий не найдено");
            return Collections.emptyList();
        }
        double tmpSqrt = Math.sqrt(disc);
        double abScalingFactor1 = -pBy2 + tmpSqrt;
        double abScalingFactor2 = -pBy2 - tmpSqrt;

        Point p1 = new Point(pointA.x - baX * abScalingFactor1, pointA.y
                - baY * abScalingFactor1, pointA.z - baZ * abScalingFactor1) ;
        if (disc == 0) {
            return Collections.singletonList(p1);
        }
        Point p2 = new Point(pointA.x - baX * abScalingFactor2, pointA.y
                - baY * abScalingFactor2, pointA.z - baZ * abScalingFactor2);
        return Arrays.asList(p1, p2);
    }

    static class Point {
        double x, y, z;

        public Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Intersection [x=" + x + ", y=" + y + ", z=" + z + "]";
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(getSphereLineIntersectionPoint(new Point(-3, -3, -3),
                new Point(-3, 3, 3), new Point(0, 0, 0), 5));
    }
}
