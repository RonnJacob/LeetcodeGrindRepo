import java.util.*;


public class BinaryTreeZigZag {

    public static void BinaryTreeZigZagMethod(TreeNode root){

        if(root == null){
            return;
        }

        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Integer> levelQueue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();

        boolean leftOrder = false;

        nodeQueue.add(root);
        nodeQueue.add(null);

        while(!nodeQueue.isEmpty()){
            TreeNode n = nodeQueue.pollFirst();

            if(n != null){

                if(leftOrder){
                    levelQueue.addFirst(n.val);
                }
                else{
                    levelQueue.addLast(n.val);
                }

                if(n.left != null){
                    nodeQueue.addLast(n.left);
                }

                if(n.right != null){
                    nodeQueue.addLast(n.right);
                }
            }
            else {
                result.add(levelQueue);
                levelQueue = new LinkedList<>();

                if(nodeQueue.isEmpty()){
                    nodeQueue.addLast(null);
                }
                
                leftOrder = leftOrder == true ? false: true;
            }
        }

        for(int i=0; i<result.size(); i++){
            for(int j=0; j<result.get(i).size(); j++){
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        System.out.println("\n103. Binary Tree Zigzag Level Order Traversal\n");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);


        BinaryTreeZigZagMethod(root);
    }
    
}