package blind;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int r = height.length-1;
        while(l<r){
            int smaller_height = Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, smaller_height *(r-l));
             if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxArea;
    }
        
    public static void main(String[] args){
        System.out.println("\n Container with the most water");
        int[] height = new int[]{4,3,2,1,4};
        System.out.println(maxArea(height));
    }
    
}
