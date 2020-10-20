package blind;

public class HouseRobberII {


    public static int hr_helper(int[] nums, int start, int end){
        // 1 2 3 1
        int t1 = 0;
        int t2 = 0;
        for(int i=start; i<=end; i++){
            int temp = t1;
            int curr = nums[i];
            t1 = Math.max(curr+t2, t1);
            t2 = temp;
        }
        return t1;
    }

    public static int rob(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int first = hr_helper(nums, 0, nums.length-2);
        int second = hr_helper(nums, 1, nums.length-1);
        return Math.max(first, second);

    }


    public static void main(String[] args){
        System.out.println("\n 213. House Robber II");
        int[] nums = new int[]{2,3,2};
        System.out.println(rob(nums));
    }
    
}
