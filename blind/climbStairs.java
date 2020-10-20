package blind;

public class climbStairs {
    /*
    You are climbing a stair case. It takes n steps to reach to the top.
    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    */
    public static int climbStairsMethod(int n){
        if(n == 0 || n == 1 || n==2){
            return n;
        }
        // Initializing a resultant array to tell stairs.
        int[] result = new int[n+1];
        result[1] = 1;
        result[2] = 2;
        int stepCounter = 3;
        while(stepCounter <=n){
            result[stepCounter] = result[stepCounter -1] + result[stepCounter-2];
            stepCounter++;
        }
        return result[n];
    }
    
    public static void main(String[] args){
        System.out.println("\n Climbing Stairs");
        int n = 4;
        System.out.println("Number of ways to climb to the top for " + n + " is " + climbStairsMethod(n));
    }
    
}
