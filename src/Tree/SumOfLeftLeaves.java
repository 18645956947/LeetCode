package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. ×óÒ¶×ÓÖ®ºÍ
 * @author zhx
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 0;
        while(queue.peek() != null){
            TreeNode r = queue.poll();
            if(r.left != null){
                queue.add(r.left);
                if(r.left.left == null && r.left.right == null){
                    sum+=r.left.val;
                }

            }
            if(r.right != null){
                queue.add(r.right);
            }

        }
        return sum;
    }

    int res;
    public  int sumOfLeftLeaves_01(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left!= null && root.left.left == null&&root.left.right == null){
            res += root.left.val;
        }
        sumOfLeftLeaves_01(root.left);
        sumOfLeftLeaves_01(root.right);
        return res;
    }
}
