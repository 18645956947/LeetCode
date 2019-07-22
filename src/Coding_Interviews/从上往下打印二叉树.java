package Coding_Interviews;

import java.util.*;

import util.TreeNode;

/**
 * 剑指offer -- 从上往下打印二叉树
 * @author zhx
 */
public class 从上往下打印二叉树 {

    //广度优先遍历
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return null;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            res.add(temp.val);
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //System.out.println(PrintFromTopToBottom(root));
        List<Integer> list = new ArrayList<>();
        System.out.println(list.getClass());
        ArrayList<Integer> ll = new ArrayList<>();
        System.out.println(ll.getClass());

    }
}
