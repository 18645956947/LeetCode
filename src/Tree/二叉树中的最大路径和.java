package Tree;

/**
 * 124 - 二叉树的最大路径和
 * @author zhx
 *
 */
public class 二叉树中的最大路径和 {
    int max_num = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_num;
    }
    private int max_gain(TreeNode node){
        if(node == null){
            return 0;
        }
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);
        int cur_num = node.val + left_gain + right_gain;
        max_num = Math.max(cur_num, max_num);
        return node.val + Math.max(left_gain, right_gain);
    }
}
