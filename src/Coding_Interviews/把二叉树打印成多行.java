package Coding_Interviews;

import util.InsertTreeNode;
import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 剑指offer -- 把二叉树打印成多行
 * @author zhx
 */
public class 把二叉树打印成多行 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(pRoot == null){
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(pRoot);
        while(!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList();
            for(int i = 0;i < size;i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = InsertTreeNode.insertTreeNode();
        ArrayList<ArrayList<Integer>> ll = Print(root);
        System.out.println(ll);
    }
}
