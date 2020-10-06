import java.util.*;

import javax.swing.tree.TreeNode;

class TreeNodeSS{
    private TreeNodeSS left;
    private TreeNodeSS right;
    private int val;

    TreeNodeSS(int v){
        this.val = v;
    }

    TreeNodeSS addLeft(int v){
        this.left = new TreeNodeSS(v);
        return this;
    }

    TreeNodeSS addRight(int v){
        this.right = new TreeNodeSS(v);
        return this;
    }

    TreeNodeSS getLeft(){
        return this.left;
    }

    TreeNodeSS getRight(){
        return this.right;
    }

    int getValue(){
        return this.val;
    }
}

public class SameStructure {

    // Recursive Iteration of Tree
    public static boolean printTree(TreeNodeSS n, TreeNodeSS n2){
        Queue<TreeNodeSS> queue = new LinkedList<>();
        Queue<TreeNodeSS> queue2 = new LinkedList<>();

        if(n!=null && n2!=null){
            queue.offer(n);
            queue2.offer(n);
        }
        else{
            return false;
        }
        while(!queue.isEmpty() && !queue2.isEmpty()){
            TreeNodeSS poppedNode = queue.poll();
            TreeNodeSS poppedNode2 = queue2.poll();

            
            if(poppedNode.getValue() != poppedNode2.getValue()){
                return false;
            }
            queue.offer(poppedNode.getLeft());
            queue.offer(poppedNode.getRight());
            System.out.println(poppedNode.getLeft().getValue() + " added to queue");
            System.out.println(poppedNode.getRight().getValue() + " added to queue");

            queue2.offer(poppedNode2.getLeft());
            queue2.offer(poppedNode2.getRight());

            System.out.println(poppedNode2.getLeft().getValue() + " added to queue2");
            System.out.println(poppedNode2.getRight().getValue() + " added to queue2");
            
        }

        if(!queue.isEmpty() || !queue2.isEmpty()){
            return false;
        }
        return true;


    }
    public static void main(String[] args){
        TreeNodeSS n = new TreeNodeSS(5);
        n.addLeft(3);
        n.addRight(7);
        n.getLeft().addLeft(1);
        n.getRight().addLeft(6);

        TreeNodeSS n2 = new TreeNodeSS(5);
        n2.addLeft(3);
        n2.addRight(7);
        n2.getLeft().addLeft(1);
        n2.getRight().addLeft(6);

        System.out.println(printTree(n, n2));


    }
    
}
