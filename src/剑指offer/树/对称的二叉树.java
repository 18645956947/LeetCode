package ��ָoffer.��;

/**
 * ��ָoffer - �ԳƵĶ�����
 * @author zhx
 */
public class �ԳƵĶ����� {

    boolean isSymmetrical(TreeNode pRoot) {
        //�������侵�������
        //�϶���ʹ�õݹ���
        //�Ƚ�left.right == right.left
        if(pRoot == null){
            return true;
        }
        return f(pRoot.left, pRoot.right);
    }

    public boolean f(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        if(t1 == null || t2 == null){
            return false;
        }
        return t1.val == t2.val && f(t1.left, t2.right);
    }
}
