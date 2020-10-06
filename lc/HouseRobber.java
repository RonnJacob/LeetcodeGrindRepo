public class HouseRobber{

    public static void houseRobberCalc(int[] args){
        int currMax = 0;
        int prevMax = 0;
        for(int num: args){
            int temp = currMax;
            currMax = Math.max(prevMax + num, currMax);
            prevMax = temp;
        }
        System.out.println(currMax);
    }
    public static void main(String[] args){
        System.out.println("Hello World.");
        int[] arr = new int[]{1,98,3,1,99};
        houseRobberCalc(arr);
    }

    /*
    0+1,0

    currMax = 1
    prevmax = 0

    0+2,1

    */
}