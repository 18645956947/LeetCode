package Tree;

/**
 * 538. 把二叉搜索树转换为累加树
 * @author zhx
 */
public class convertBST {

    public TreeNode convertBST(TreeNode root) {
        dfs(root, 0);
        return root;

    }
    private int dfs(TreeNode node, int sum){
        if(node == null){
            return sum;
        }
        int right_value = dfs(node.right, sum);
        node.val += right_value;
        int left_value = dfs(node.left, node.val);
        return left_value;

    }
}
