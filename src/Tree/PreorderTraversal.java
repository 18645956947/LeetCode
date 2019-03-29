package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. 二叉树的前序遍历
 * @author zhx
 * 递归实现树的先序遍历
 */
public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        printVal(root, list);
        return list;
    }
    public void printVal(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        list.add(node.val);
        if(node.left!=null){
            printVal(node.left, list);
        }
        if(node.right!=null){
            printVal(node.right, list);
        }
    }


    /**
     * 迭代实现树的先序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversa2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            list.add(top.val);
            if(top.right!=null){
                stack.push(top.right);
            }
            if(top.left!=null){
                stack.push(top.left);
            }
        }
        return list;
    }



}
