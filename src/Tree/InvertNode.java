package Tree;

/**
 * 226. ��ת������
 * �ݹ鷽����ת��
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
