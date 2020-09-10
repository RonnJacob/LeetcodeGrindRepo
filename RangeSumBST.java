import java.util.*;
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
public class RangeSumBST {
    public static int rangeSumBST(TreeNode root, int L, int R){
        if(root == null ){
            return 0;
        }
        
        if(root.val < L){
            return rangeSumBST(root.right, L, R);
        }
        
        if(root.val > R){
            return rangeSumBST(root.left, L, R);
        }
        
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R); 
    }
    
    public static void main(String[] args){
        System.out.println("\n938. Range Sum of BST");
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(18);

        System.out.println("Range Sum of BST : " + rangeSumBST(root, 7, 15));
    }
    
    
}
