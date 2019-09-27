package Tree;

/**
 * leetcode -- 543.二叉树的直径
 * @author zhx
 */
public class 二叉树的直径 {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //左右子树的深度和的最大值即是答案
        depth(root);
        return res;
    }
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        res = Math.max(L+R, res);
        return Math.max(L, R) + 1;
    }
}
