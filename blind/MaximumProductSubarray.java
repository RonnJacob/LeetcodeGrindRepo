
package blind;
public class MaximumProductSubarray {

    public static int maximumProductSubarray(int[] nums){
        int minSoFar = nums[0];
        int maxSoFar = nums[0];
        int result = nums[0];
        // If zero is encountered, check result so far and see if it is greater than the previous result. 
        // It's just a simple disruption.

        
        // max(curr_number, curr_number*maxsofar, curr_number *minsofar)

        for(int i=1; i<nums.length; i++){
            if(nums[i] == 0 && maxSoFar > result){
                result = maxSoFar;
                maxSoFar = 1;
                minSoFar = 1;
            }
            else{
                int maxSF = maxSoFar;
                int minSF = minSoFar;
                maxSoFar = Math.max(nums[i], Math.max(nums[i]*maxSF, nums[i]*minSF));
                minSoFar = Math.min(nums[i], Math.min(nums[i]*maxSF, nums[i] *minSF));
                if(maxSoFar > result){
                    result = maxSoFar;
                }
            }
        }

        return result;

    }

    public static void main(String[] args){
        System.out.println("\n Maximum Product Subarray");
        int[] arr = new int[]{2,3,-2,4};
        System.out.println(maximumProductSubarray(arr));
    }
}
