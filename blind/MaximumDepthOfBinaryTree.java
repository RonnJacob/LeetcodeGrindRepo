package blind;

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
public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q){

       if(p == null && q == null){
           return true;
       }
       if(p == null || q == null){
           return false;
       }

       if(p.val != q.val){
           return false;
       }

       return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args){
        System.out.println("\n104. Maximum Depth of Binary Tree");
        TreeNode root =new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        TreeNode root2 =new TreeNode(3);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        TreeNode r1 = new TreeNode(1);
        r1.left = new TreeNode(2);

        TreeNode r2 = new TreeNode(1);
        r2.right = new TreeNode(2);

        System.out.println(isSameTree(root, root2));


    }
    
}
