package Tree;

/**
 * 1008. 先序遍历构造二叉树
 * @author zhx
 */
public class BstFromPreorder {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i  = 0;i<preorder.length;i++){
            root = add(root, preorder[i]);
        }
        return root;


    }
    public TreeNode add(TreeNode root, int num){
        if(root == null){
            return new TreeNode(num);
        }
        if(root.val < num){
            root.right = add(root.right, num);
        }
        if(root.val > num){
            root.left = add(root.left, num);
        }
        return root;
    }
}
