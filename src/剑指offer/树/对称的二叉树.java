package 剑指offer.树;

/**
 * 剑指offer - 对称的二叉树
 * @author zhx
 */
public class 对称的二叉树 {

    boolean isSymmetrical(TreeNode pRoot) {
        //就是求其镜像二叉树
        //肯定是使用递归啦
        //比较left.right == right.left
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
