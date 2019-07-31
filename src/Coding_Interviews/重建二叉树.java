package Coding_Interviews;

import util.TreeNode;

/**
 * 剑指offer -- 重建二叉树
 * @author zhx
 */
public class 重建二叉树 {

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn){
        if(startPre > endPre || startIn > endIn){
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for(int i = 0;i <= endIn;i++){
            if(pre[startPre] == in[i]){
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i-startIn, in, startIn, i-1);
                root.right = reConstructBinaryTree(pre, i-startIn+startPre+1, endPre, in, i +1, endIn);
                break;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        int[] pre =  new int[]{1,2,4,7,3,5,6,8};
        int[] in =  new int[]{4,7,2,1,5,3,8,6};
        TreeNode root = 重建二叉树.reConstructBinaryTree(pre, in);

    }
}
