class TreeNodeS {
    int val;
    TreeNodeS left;
    TreeNodeS right;
    TreeNodeS (int x) { val = x; }
}
public class LCABST {

    public static TreeNodeS lowestCommonAncestor(TreeNodeS root, TreeNodeS p, TreeNodeS q) {
        if(root == null || p == null || q == null){
            return null;
        }

        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,  p,  q) ;
        }
        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,  p, q) ;
        }
        else{
            return root;
        }
    }

    public static void main(String[] args){
        System.out.println("\n235. Lowest Common Ancestor of a Binary Search Tree");
        TreeNodeS n = new TreeNodeS(6);
        n.left = new TreeNodeS(2);
        n.right = new TreeNodeS(8);

        n.left.left = new TreeNodeS(0);
        n.left.right = new TreeNodeS(4);
        n.left.right.left = new TreeNodeS(3);
        n.left.right.right = new TreeNodeS(5);

        n.right = new TreeNodeS(8);
        n.right.left = new TreeNodeS(7);
        n.right.right = new TreeNodeS(9);      

        System.out.println(lowestCommonAncestor(n, n.left, n.left.right).val);
    }
    
}
