package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 * @author zhx
 * 跟102二叉树的层序遍历一样，本题利用一个flag 再利用一个Collections工具类 把list中的元素反转就好了
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }
        list.add(root);
        boolean flag = true;
        while (!list.isEmpty()){
            List<TreeNode> nextNode = new ArrayList<TreeNode>();
            List<Integer> curList = new ArrayList<>();
            for(TreeNode node : list){
                curList.add(node.val);
                if (node.left != null) {
                    nextNode.add(node.left);
                }
                if (node.right != null) {
                    nextNode.add(node.right);
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
}
