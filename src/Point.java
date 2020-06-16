import java.util.ArrayList;
import java.util.List;

public class Point {
    ArrayList<Double> atributes;


    public Point(ArrayList<Double> artibutes) {
        this.atributes = new ArrayList<>(artibutes);
    }


    public double distance(Point point) {
        double distance = 0;
        for (int i = 0; i < atributes.size(); i++) {

            distance += Math.pow(point.atributes.get(i) - atributes.get(i), 2);


        }
        return distance;


    }

}
