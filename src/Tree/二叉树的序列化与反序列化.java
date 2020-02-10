package Tree;

/**
 * 297. 二叉树的序列化与反序列化
 * @author zhx
 */
public class 二叉树的序列化与反序列化 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String str = "";
        if(root == null){
            str += "#!";
        }
        else{
            str += root.val + "!";
            str += serialize(root.left);
            str += serialize(root.right);
        }
        return str;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split("!");
        Queue<String> queue = new LinkedList();
        for(String str : values){
            queue.add(str);
        }
        return deserialize1(queue);
    }

    public TreeNode deserialize1(Queue<String> queue){
        String str = queue.poll();
        if(str.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = deserialize1(queue);
        node.right = deserialize1(queue);
        return node;
    }
}
