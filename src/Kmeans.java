import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Kmeans {


    public static List<Point> getDane(String pat) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File(pat)));
        List<Point> list = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            ArrayList<Double> doublesList = new ArrayList<>();
            String[] r = line.split(";");
            for (int i = 0; i < r.length; i++) {
                double val = Double.parseDouble(r[i]);
                doublesList.add(val);

            }
            // System.out.println(doublesList);
            list.add(new Point(doublesList));
        }
        br.close();

        System.out.println(list.size());

        return list;
    }

    public static List<Centroid> getRandomCentroid(int k, int amountOfAtributes) {
        List<Centroid> centList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < k; i++) {
            ArrayList<Double> arrayList = new ArrayList<>();

            for (int j = 0; j < amountOfAtributes; j++) {
                arrayList.add(random.nextDouble() * 100); //zmien zakres zaleznie od danych

            }
            centList.add(new Centroid(arrayList));

        }
        return centList;
    }

    public static int closestCentroid(Point point, List<Centroid> centroids) {

        int numberCentroid = 0;
        double soFarDistance = point.distance(centroids.get(0));

        for (int i = 0; i < centroids.size(); i++) {
            double distance = point.distance(centroids.get(i));
            if (distance < soFarDistance) {
                numberCentroid = i;
                soFarDistance = distance;
            }

        }

        centroids.get(numberCentroid).centroidPoints.add(point);
        return numberCentroid;

    }


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj Liczbe k: ");
        int K = sc.nextInt();
        System.out.println("Podaj scieżkę pliku: ");
        String path = sc.next();
        System.out.println("------------------");

        List<Point> points = getDane(path);
      //  System.out.println(points.get(0).atributes);
        List<Centroid> centroids = getRandomCentroid(K, points.get(0).atributes.size());

        boolean b = true;
   int x =1;

   double E = -1.0;
   double nextE = 0;


   while (E!=nextE) {

       E = nextE;
       nextE = 0;
            for (int i = 0; i < points.size(); i++) {
                closestCentroid(points.get(i), centroids);
            }
            for (int i = 0; i < centroids.size(); i++) {
                System.out.println("Centroid numer: " + i + " suma: " + centroids.get(i).getSum() +" wspolrzedne centroidu: "+ centroids.get(i).atributes);
                System.out.println("Zawiera on dane pkt: ");

                for (int j = 0; j < centroids.get(i).centroidPoints.size(); j++) {
                    System.out.println(centroids.get(i).centroidPoints.get(j).atributes);


                }

             nextE += centroids.get(i).getSum();
            }
           for(int i=0;i<centroids.size();i++){
               centroids.get(i).calculateNewCentroid();
               centroids.get(i).centroidPoints.clear();
           }


        }


    }


}





