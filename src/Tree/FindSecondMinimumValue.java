package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 671. 二叉树中第二小的节点
 * @author zhx
 */
public class FindSecondMinimumValue {
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null){
            return -1;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int min = root.val;
        int res = Integer.MAX_VALUE;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.val > min){
                res = Math.min(res, temp.val);
            }
            if(root.left != null){
                queue.offer(root.left);
            }
            if (root.right != null){
                queue.offer(root.right);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
