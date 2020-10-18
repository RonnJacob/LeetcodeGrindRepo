package blind;

public class MinimumInRotatedSortedArray {

    public static int findMin(int[] nums){
        if(nums.length  == 1){
            return nums[0];
        }


        if(nums[0] < nums[nums.length-1]){
            return nums[0];
        }

        int left = 0, right = nums.length-1;
        while(right>=left){
            int mid = left+(right-left)/2;

            if(nums[mid]> nums[mid+1]){
                return nums[mid+1];
            }

            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }

            if(nums[mid] > nums[left]){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        System.out.println("\n Blinds: 153 Find Minimum in Rotated Sorted Array");
        int[] nums = new int[]{1,2};
        System.out.println(findMin(nums));
    }
    
}
