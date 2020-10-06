public class SubtreeofAnotherTree {

    public static boolean isIdentical(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null){
            return false;
        }
        if(t2 == null){
            return false;
        }

        return t1.val == t2.val && isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {

        if(s == null && t == null){
            return true;
        }

        if(s == null ){
            return false;
        }

        if(t == null ){
            return false;
        }

        return isIdentical(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public static void main(String[] args){
        System.out.println("\n 572. Subtree of Another Tree");
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(4);
        t1.left.left = new TreeNode(1);
        t1.left.right = new TreeNode(2);
        t1.left.right.left = new TreeNode(0);
        t1.right = new TreeNode(5);

        TreeNode t2 = new TreeNode(4);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(2);

        System.out.println(isSubtree(t1, t2));
    }
    
}
