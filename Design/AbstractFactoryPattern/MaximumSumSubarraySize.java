package Design.AbstractFactoryPattern;
import java.util.*;

public class MaximumSumSubarraySize {

    public static void calculateKtermaverage(int K, int[] arr){
        List<Double> result = new ArrayList<>();
        
        double alreadyCalculated = -1;
        for(int i=0; i+K<=arr.length; i++){
            if(alreadyCalculated == -1){
                int sum = 0;
                for(int j=0; j<K; j++){
                    sum += arr[j];
                }
                alreadyCalculated = (double)sum/K;
                result.add(alreadyCalculated);
            }
            else{
                alreadyCalculated = (alreadyCalculated*K- arr[i-1] + arr[i+K-1])/K;
                result.add(alreadyCalculated);
            }
        }

        for(Double res: result){
            System.out.println(res);
        }
    }
    public static void main(String[] args){
        System.out.println("\n Hello World");
        int[] arr = new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2};
        int K = 5;
        calculateKtermaverage(K, arr);
    }
    
}
