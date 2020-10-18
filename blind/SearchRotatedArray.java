package blind;

public class SearchRotatedArray {

    public static int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target){
            return 0;
        }

        int left = 0, right = nums.length-1;
        while(right>=left){
            int mid = left+(right-left)/2;

            if(nums[mid] == target){
                return mid;
            }

         
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{
                if(target >= nums[mid+1] && target <= nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args){
        System.out.println("Blind 75 : Search In Rotated Array");
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
    
}
