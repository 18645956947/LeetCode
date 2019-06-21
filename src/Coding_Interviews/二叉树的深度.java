package Coding_Interviews;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode{

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val){
        this.val = val;
    }
}

/**
 * 剑指offer ---二叉树的深度
 * @author zhx
 *
 */
public class 二叉树的深度 {

    //迭代方法
    public int TreeDepth_01(TreeNode root) {
        if(root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;
            for(int i = 0;i<size;i++){
                TreeNode cur = queue.poll();
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
            }

        }

        return depth;
    }


    //递归版本
    public int  TreeDepth_02(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = TreeDepth_02(root.left);
        int right = TreeDepth_02(root.right);
        return Math.max(left, right) + 1;
    }

}
