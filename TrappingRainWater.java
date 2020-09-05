public class TrappingRainWater {

    public static int trap(int[] height) {
        int result = 0;
        int maxRightHeight = 0;
        int maxLeftHeight = 0;
        int[] maxRHeights = new int[height.length];
        int[] maxLHeights = new int[height.length];
        for(int i=1; i<height.length; i++){
            maxLeftHeight = 0;
            maxRightHeight = 0;
            for(int j=i-1; j>=0; j--){
                if(height[j] > maxLeftHeight){
                    maxLeftHeight = height[j];
                }
            }

            for(int j=i+1; j<height.length; j++){
                if(height[j]>maxRightHeight){
                    maxRightHeight = height[j];
                }
            }
            result += (Math.min(maxLeftHeight, maxRightHeight) - height[i]) < 0 ? 0 : Math.min(maxLeftHeight, maxRightHeight) - height[i];
            
        }

        return result;
    }


    // Dynamic Programming

    public static int trap2(int[] arr){

        int[] rightMax = new int[arr.length];
        int[] leftMax = new int[arr.length];
        int result = 0;

        int rightMaxVal = 0;
        int leftMaxVal = 0;
        leftMax[0] = 0;
        rightMax[arr.length-1] = 0;

        for(int i=arr.length-1; i>=1 ; i--){
            rightMax[i-1] = Math.max(arr[i], rightMaxVal);
            rightMaxVal = rightMax[i-1];

            System.out.println(rightMax[i-1]);
        }

        for(int i=0; i<= arr.length-2 ; i++){
            leftMax[i+1] = Math.max(arr[i], leftMaxVal);
            leftMaxVal = leftMax[i+1];
        }

        for(int i=0; i<arr.length; i++){
            result += (Math.min(leftMax[i], rightMax[i]) - arr[i]) < 0 ? 0: (Math.min(leftMax[i], rightMax[i]) - arr[i]); 
        }
        return result;
    }
    


    public static void main(String[] args){
        System.out.println("\n42. Trapping Rain Water");
        int[] elevations = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap2(elevations));
        
    }
    
}
