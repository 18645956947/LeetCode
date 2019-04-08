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
        if (root == null || root.left == null)
            return -1;
        Queue<TreeNode> queue = new LinkedList<>();
        int min = root.val, res = Integer.MAX_VALUE;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.val > min)
                    res = Math.min(res, temp.val);
                if (temp.left != null)
                    queue.offer(temp.left);
                if (temp.right != null)
                    queue.offer(temp.right);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
