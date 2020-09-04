package 剑指offer.树;

import java.util.Arrays;

/**
 * 剑指offer - 重建二叉树
 * @author zhx
 */
public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length == 0){
            return null;
        }
        //定义根节点
        int rootval = pre[0];
        if(pre.length == 1){
            return new TreeNode(rootval);
        }
        int rootIndex = 0;
        TreeNode root = new TreeNode(rootval);
        for(int i=0;i< in.length;i++){
            if(in[i] == rootval){
                rootIndex = i;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0, rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in, rootIndex + 1, in.length));

        return root;
    }
}
