package blind;

public class JumpGame {



    public static boolean canJump(int[] nums){

        if(nums.length < 2){
            return true;
        }

        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] == 0){
                int jump = 1;
                while(jump > nums[i]){
                    jump++;
                    i--;

                    if(i < 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println("\n Jump Game.\n");
        int[] nums = new int[]{3,2,1,0,4};
        System.out.println(canJump(nums));


    }
    
}
