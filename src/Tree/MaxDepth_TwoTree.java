package Tree;

import org.omg.CORBA.NO_IMPLEMENT;

import javax.swing.event.TreeExpansionEvent;
import java.util.Map;

/**
 * 104. 二叉树的最大深度
 * @author zhx
 */
public class MaxDepth_TwoTree {
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
    public static void main(String[] args){
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.right = new TreeNode(5);
        System.out.println(MaxDepth_TwoTree.maxDepth(node1));
    }
}
