package Coding_Interviews;

import util.TreeNode;

/**
 * ��ָoffer -- ������������˫������
 * �ݹ�ʵ��
 * @author zhx
 */
public class ������������˫������ {

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
    //TODO  �ǵݹ�汾

}
