package Coding_Interviews;

import org.omg.CORBA.PRIVATE_MEMBER;
import sun.reflect.generics.tree.Tree;

/**
 * ��ָoffer -- ƽ�������
 * @author zhx
 */
public class ƽ������� {

    public static boolean IsBalanced_Solution(TreeNode root) {
        if(root == null) {
            return true;
        }
        return getDepth(root) != -1;
    }

    private static int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(left == -1){
            return -1;
        }
        if(right == -1){
            return -1;
        }
        return Math.abs((left - right) > 1 ? -1 : 1 + Math.max(left, right));
    }

    public static int text(int i){
        return i;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        System.out.println(IsBalanced_Solution(root));
        System.out.println(text(7) != -1);
    }
}
