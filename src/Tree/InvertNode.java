package Tree;

/**
 * 226. 翻转二叉树
 * 递归方法旋转树
 */
public class InvertNode {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.right;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
