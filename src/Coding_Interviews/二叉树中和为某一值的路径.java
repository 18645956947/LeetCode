package Coding_Interviews;

import util.InsertTreeNode;
import util.TreeNode;

import java.util.ArrayList;

/**
 * 剑指offer -- 二叉树中和为某一值的路径
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
        if(target == 0 && root.left ==null && root.right == null){
            res.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return res;
    }

    public static void main(String[] args) {
        二叉树中和为某一值的路径 q = new 二叉树中和为某一值的路径();
        TreeNode root = InsertTreeNode.insertTreeNode();
        ArrayList<ArrayList<Integer>> ll = q.FindPath(root, 7);
        System.out.println(ll);
    }
}
