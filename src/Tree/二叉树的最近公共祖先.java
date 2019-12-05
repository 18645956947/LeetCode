package Tree;

import java.util.*;

/**
 * leetcode - 二叉树的最近公共祖先
 * 思路就是 ： 首先用一个队列存储所有的包含pq的节点，采用层次遍历
 * 一个 Map存储所有节点对应的父节点的字典
 * 然后在存储完所有的节点的时候，用一个set记录p所有的父节点，然后遍历q的父节点，第一个在p的set里的就是第一个公共节点
 * @author zhx
 */
public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque();
        Map<TreeNode, TreeNode> parent = new HashMap();
        parent.put(root, null);
        stack.push(root);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> set = new HashSet();
        while(p != null){
            set.add(p);
            p = parent.get(p);
        }
        while(!set.contains(q)){
            q = parent.get(q);
        }
        return q;

    }
}
