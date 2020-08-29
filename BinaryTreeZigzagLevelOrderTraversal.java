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
 
public class BinaryTreeZigzagLevelOrderTraversal {

    public static void Traverse(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> levelMapping = new HashMap<>();
        queue.offer(root);
        levelMapping.put(root, 1);
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode poppedNode = queue.poll();

            if(poppedNode.left != null){
                queue.offer(poppedNode.left);
                levelMapping.put(poppedNode.left, levelMapping.get(poppedNode)+1);
            }

            if(poppedNode.right != null){
                queue.offer(poppedNode.right);
                levelMapping.put(poppedNode.right, levelMapping.get(poppedNode)+1);
            }
            
        }

    }
    public static void main(String[] args){
        System.out.println("\n103. Binary Tree Zigzag Level Order Traversal\n");
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

    }
    
}