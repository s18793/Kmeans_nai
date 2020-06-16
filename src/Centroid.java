import java.util.ArrayList;

public class Centroid extends Point {
public ArrayList<Point> centroidPoints;

    public Centroid(ArrayList<Double> artibutes) {
        super(artibutes);
        centroidPoints=new ArrayList<>();
    }



    public double getSum(){ //e
        double sum=0;
        for(int i =0; i<centroidPoints.size(); i++){

            sum+=distance(centroidPoints.get(i));
        }
        return sum;
    }

    public void calculateNewCentroid(){

        double result;
        ArrayList<Double> resultList = new ArrayList<>();
        for(int i =0; i<atributes.size(); i++){
        double suma=0;

            for(int j=0; j< centroidPoints.size();j++){
               suma += centroidPoints.get(j).atributes.get(i);
            }
            result = suma/centroidPoints.size();
            resultList.add(result);

        }
        this.atributes=resultList;


    }



}
