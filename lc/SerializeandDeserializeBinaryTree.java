import java.util.*;

public class SerializeandDeserializeBinaryTree {
    
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder("");
        if(root != null){
            s.append(root.val + ",");
            s.append(serialize(root.left));
            s.append(serialize(root.right));
        }
        else{
            s.append("null"+",");
        }
        return s.toString();
    }


    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> treeNodes = new LinkedList<>();
        treeNodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(treeNodes);
    }

    public static TreeNode buildTree(Queue<String> nodes){
        String poppedNode = nodes.remove();
        if(poppedNode.equals("null")){
            return null;
        }
        else{
            TreeNode n = new TreeNode(Integer.parseInt(poppedNode));
            n.left = buildTree(nodes);
            n.right = buildTree(nodes);
            return n;
        }
    }

    public static void traverseTree(TreeNode root){
        if(root  == null){
            return;
        }
        System.out.print(root.val + " ");
        traverseTree(root.left);
        traverseTree(root.right);
    }

    public static void main(String[] args){
        System.out.println("\n297. Serialize and Deserialize Binary Tree");
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


        TreeNode res = deserialize("1,2,null,null,3,4,null,null,5,null,null,");
        System.out.println("Initial Tree : Unserialized");
        traverseTree(root);
        System.out.println();
        System.out.println();
        System.out.println("Serialized Tree: ");
        System.out.println(serialize(root));
        System.out.println();
        System.out.println("Deserialized Tree: ");
        traverseTree(res);
        System.out.println();
        System.out.println();


    }
}
