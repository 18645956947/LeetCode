package ��ָoffer.�ֽ��ø��������;

import ��ָoffer.��.TreeNode;

import java.util.Stack;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 * @author zhx
 */
public class ������������˫������ {
    //�ǵݹ����� �����������
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
                //������ڵ������ͷ�ڵ�
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

    //�ݹ�汾ʵ��
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
