package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * @author zhx
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
}
