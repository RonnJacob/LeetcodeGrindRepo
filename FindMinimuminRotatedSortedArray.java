public class FindMinimuminRotatedSortedArray{

    public static void helper(int[] num){
        int l = 0;
        int r = num.length-1;
        int m = l+(r-l)/2;
        if(num.length == 1){
            System.out.println(num[0]);
            return;
        }
        if(num.length == 2){
            System.out.println(num[0]>num[1]? num[1]: num[0]);
            return;
        }

        if(num.length == 0){
            return;
        }
        while(l<=r || r-l > 1){
            m = l+(r-l)/2;
            if(num[m] == num[l]){
                if(num[m] > num[m+1]){
                    System.out.println(num[m+1]);
                }
                else if(num[m] <= num[m+1]){
                    System.out.println(num[0]);
                }
                return;
            }

            if(num[m] > num[l]){
                l = m;
            }
            else if(num[m] < num[l]){
                r = m;
            }
        }
    }
    public static void main(String[] args){
        System.out.println("153. Find Minimum in Rotated Sorted Array");
        int[] nums = new int[]{7,8,0,3,4,5,6};
        helper(nums);

    }
}