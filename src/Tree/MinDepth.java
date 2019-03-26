package Tree;

/**
 * 111. ����������С���
 * @author zhx
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left,right;
        if(root.left != null){
            left = minDepth(root.left);
        }
        else{
            left = Integer.MAX_VALUE;
        }
        if(root.right != null){
            right = minDepth(root.right);
        }
        else{
            right = Integer.MAX_VALUE;
        }

        return Math.min(left, right)+1;
    }
}
