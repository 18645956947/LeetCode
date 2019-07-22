package Coding_Interviews;

import util.TreeNode;

/**
 * 剑指offer -- 平衡二叉树
 * @author zhx
 */
public class 平衡二叉树 {

    public static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }
        return getDepth(root) != -1;
    }

    private static int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(left == -1){
            return -1;
        }
        if(right == -1){
            return -1;
        }
        return Math.abs((left - right) > 1 ? -1 : 1 + Math.max(left, right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        System.out.println(IsBalanced_Solution(root));
    }
}
