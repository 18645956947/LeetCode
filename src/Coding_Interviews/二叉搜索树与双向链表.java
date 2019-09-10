package Coding_Interviews;

import util.TreeNode;

/**
 * 剑指offer -- 二叉搜索树与双向链表
 * 递归实现
 * @author zhx
 */
public class 二叉搜索树与双向链表 {

    TreeNode leftHead = null;
    TreeNode rightHead= null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Convert(pRootOfTree.left);
        if(rightHead == null){
            leftHead = rightHead = pRootOfTree;
        }
        else{
            rightHead.right = pRootOfTree;
            pRootOfTree.left = rightHead;
            rightHead = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return leftHead;
    }
    //TODO  非递归版本

}
