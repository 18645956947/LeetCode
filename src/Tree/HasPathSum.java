package Tree;

/**
 * 112. Â·¾¶×ÜºÍ
 * @author zhx
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(sum == root.val && root.left == null && root.right == null){
            return true;
        }
        else return hasPathSum(root.left, sum - root.val) ||hasPathSum(root.right, sum - root.val);
    }
}
