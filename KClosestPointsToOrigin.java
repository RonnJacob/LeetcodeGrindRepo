import java.util.*;
public class KClosestPointsToOrigin {

    public static double calculateEuclideanDistance(int[] point){
        return Math.sqrt(Math.pow(point[0], 2)+ Math.pow(point[1], 2));
    }

    public static int[][] KClosestPointsToOrig(int[][] points, int K){
        Map<int[], Double> euclideanValues = new HashMap<>();
        int[][] results = new int[K][2];
        for(int i=0; i<points.length; i++){
            euclideanValues.put(points[i], calculateEuclideanDistance(points[i]));
        }

        PriorityQueue<Map.Entry<int[], Double>> pq = new PriorityQueue<>(
            (a, b)->a.getValue() == b.getValue()? Integer.compare(a.getKey()[0], b.getKey()[0]) : a.getValue().compareTo(b.getValue())
        );

        for(Map.Entry<int[], Double> entry: euclideanValues.entrySet()){
            pq.offer(entry);
        }

        int k =0;
        for(int i=0; i<K; i++){
            results[k] = pq.poll().getKey();
            k++;

        }
        return results;
    }
    public static void main(String[] args){
        System.out.println("\n973. K Closest Points to Origin\n");
        int[][] points = new int[][]{{3,3}, {5,-1}, {-2, 4}};
        int k = 2;


        int[][] kClosestPoints = KClosestPointsToOrig(points, k);
        for(int i=0; i<kClosestPoints.length; i++){
            for(int j=0; j<kClosestPoints[0].length; j++){
                System.out.print(kClosestPoints[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}