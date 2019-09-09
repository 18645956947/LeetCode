package Coding_Interviews;

/**
 * 给定一个二叉树和其中的一个结点，
 * 请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 剑指offer -- 二叉树的下一个结点
 * @author zhx
 */
public class 二叉树的下一个结点 {

    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if (pNode == null){
            return pNode;
        }
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        else if(pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }
        else if(pNode.next != null && pNode.next.right == pNode){
            while(pNode.next != null && pNode.next != pNode){
                pNode = pNode.next;
            }
            return pNode.next;
        }else{
            return pNode.next;
        }


    }
}
