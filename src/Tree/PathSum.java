package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 113. Â·¾¶×ÜºÍ II
 * @author zhx
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return result;
        }
        fun(root, sum, result, list);
        return result;

    }
    public void fun(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list){
        list.add(root.val);
        if (root.left!=null){
            fun(root.left, sum-root.val, result, list);
        }
        if(root.right!=null){
            fun(root.right, sum-root.val, result, list);
        }
        if(root.left == null && root.right == null){
            if(sum == root.val){
                result.add(new ArrayList<>(list));
            }
        }
        list.remove(list.size()-1);

    }
}
}
