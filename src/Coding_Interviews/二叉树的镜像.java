package Coding_Interviews;

/**
 * ��ָoffer---�������ľ���
 * @author zhx
 */
public class �������ľ��� {

    public void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        Mirror(root.left);
        Mirror(root.right);

    }
}
