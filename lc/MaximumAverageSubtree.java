

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class MaximumAverageSubtree {

    static double result = 0.0;
    public static double maxAverageSubtree(TreeNode root){
        calculateAvgSubtree(root);
        return result;  
    }
    
    public static double[] calculateAvgSubtree(TreeNode root){
        if(root == null){
            return new double[]{0.0, 0.0};
        }

        double[] left = calculateAvgSubtree(root.left);
        double[] right = calculateAvgSubtree(root.right);
        double sum = left[0] + right[0] + root.val;
        double count = 1 + left[1] + right[1];
        result = Math.max(result, sum/count);
        return new double[]{sum, count};
    }


    public static void main(String[] args){
        System.out.println("\n1120. Maximum Average Subtree\n");

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6);
        root.right = new TreeNode(1);


        System.out.println(maxAverageSubtree(root));
    }
    
}
