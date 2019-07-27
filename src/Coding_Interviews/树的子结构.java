package Coding_Interviews;

import util.TreeNode;

/**
 * 剑指offer -- 树的子结构
 * @author zhx
 */
public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return false;
        }
        boolean res = false;
        if(root1.val == root2.val){
            res = isTree1HasTree2(root1, root2);
        }
        if(!res){
            res = HasSubtree(root1.left, root2);
        }
        if(!res){
            res = HasSubtree(root1.right, root2);
        }
        return res;
    }
    private boolean isTree1HasTree2(TreeNode node1, TreeNode node2){
        if(node2 == null){
            return true;
        }

        if(node1 == null){
            return false;
        }

        if(node1.val != node2.val){
            return false;
        }
        return isTree1HasTree2(node1.left, node2.left) && isTree1HasTree2(node1.right, node2.right);
    }
}
