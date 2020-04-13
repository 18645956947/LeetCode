package 剑指offer.分解让复杂问题简单;

import 剑指offer.树.TreeNode;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author zhx
 */
public class 二叉搜索树与双向链表 {
    //非递归做法 就是中序遍历
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = pRootOfTree;
        TreeNode pre = null;
        TreeNode root = null;
        boolean flag = true;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(flag){
                //把最左节点给链表头节点
                root = cur;
                flag = false;
            }else{
                pre.right = cur;
                cur.left = pre;
            }
            pre = cur;
            cur = cur.right;
        }
        return root;
    }

    //递归版本实现
    TreeNode pLast = null;
    public TreeNode Convert_02(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        TreeNode head = Convert(pRootOfTree.left);
        if(head == null){
            head = pRootOfTree;
        }
        pRootOfTree.left = pLast;
        if(pLast != null){
            pLast.right = pRootOfTree;;
        }
        pLast = pRootOfTree;
        Convert(pRootOfTree.right);
        return head;
    }
}
