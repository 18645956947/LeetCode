package Tree;

import sun.reflect.generics.tree.Tree;

import javax.management.QueryEval;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 226. ��ת������
 * �ݹ鷽����ת��+�ǵݹ鷽��
 */
public class InvertNode {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.right;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    //�ǵݹ鷽��
    public TreeNode invertTree_(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode curr = stack.pop();
            TreeNode temp = curr.left;
            curr.right = curr.left;
            curr.right = temp;
            if(curr.left != null){
                stack.add(curr.left);
            }
            if(curr.right != null){
                stack.add(curr.right);
            }
        }
        return root;
    }

}
