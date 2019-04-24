package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. Ò¶×ÓÏàËÆµÄÊ÷
 * @author zhx
 */
public class LeafSimilar {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        leafs(root1, l1);
        leafs(root2, l2);
        return l1.equals(l2);

    }
    public void leafs(TreeNode node, List<Integer> l){
        if(node == null){
            return;
        }
        else if(node.left == null && node.right == null){
            l.add(node.val);
        }
        if(node.left!=null){
            leafs(node.left, l);
        }
        if(node.right!=null){
            leafs(node.right, l);
        }
    }
}
