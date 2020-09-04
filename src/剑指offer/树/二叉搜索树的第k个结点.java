package 剑指offer.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 二叉搜索树的第k个结点 {
    static TreeNode KthNode(TreeNode pRoot, int k)
    {
        if(pRoot == null || k <= 0){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(pRoot);
        ArrayList<TreeNode> res = new ArrayList();
        ArrayList<Integer> in = new ArrayList();
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode cur = queue.poll();
                res.add(cur);
                in.add(cur.val);
                if(cur.left != null){
                    queue.add(cur.left);
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                size--;
            }
        }
        if(k > res.size()){
            return null;
        }
        TreeNode tem = res.get(k - 1);
        for (int i = 0; i < in.size(); i++) {
            System.out.print(in.get(i) + " ");
        }
        return tem;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        TreeNode cur  = 二叉搜索树的第k个结点.KthNode(root, 1);
        System.out.println();
        System.out.println(cur.val);
    }
}
