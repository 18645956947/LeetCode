package Coding_Interviews;

/**
 * ��ָoffer --- �ԳƵĶ�����
 * @author zhx
 */
public class �ԳƵĶ����� {

    //�ݹ�汾
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }
    private boolean isSymmetrical(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return left.val == right.val && isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }

    //�ǵݹ�İ汾


}
