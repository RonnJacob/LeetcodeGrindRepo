public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int[] maxArr = new int[nums.length];
        int[] multArr = new int[nums.length];
        maxArr[0] = nums[0];
        multArr[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            multArr[i] = nums[i]*nums[i-1];
            maxArr[i] = Math.max(multArr[i], maxArr[i-1]);
        }

        return maxArr[nums.length-1];
        
    }
    public static void main(String[] args){
        int[] example = new int[]{-2,0,-1};
        System.out.println(maxProduct(example));
    }
    
}
