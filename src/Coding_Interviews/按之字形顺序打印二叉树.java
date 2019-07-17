package Coding_Interviews;

import java.util.*;

/**
 * 剑指offer -- 按之字形顺序打印二叉树
 * @author zhx
 */
public class 按之字形顺序打印二叉树 {

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        list.add(pRoot);
        boolean flag = true;
        while (!list.isEmpty()){
            ArrayList<TreeNode> nextNode = new ArrayList<>();
            ArrayList<Integer> curList = new ArrayList<>();
            for(TreeNode node : list){
                curList.add(node.val);
                if(node.right != null){
                    nextNode.add(node.right);
                }
                if(node.left!=null){
                    nextNode.add(node.left);
                }
            }
            if(flag){
                Collections.reverse(curList);
            }
            flag = !flag;
            result.add(curList);
            list = nextNode;
        }
        return result;
    }

    public static void insertTreeNode(TreeNode root){
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        insertTreeNode(root);
        ArrayList<ArrayList<Integer>> ll = Print(root);
        System.out.println(ll);

    }
}
