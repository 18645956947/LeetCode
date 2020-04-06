package 剑指offer.举例让抽象具体化;

import 剑指offer.树.TreeNode;

import java.util.ArrayList;

/**
 * 剑指 offer - 二叉树中和为某一值的路径
 * @author zhx
 */
public class 二叉树中和为某一值的路径 {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return res;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return res;

    }
}
