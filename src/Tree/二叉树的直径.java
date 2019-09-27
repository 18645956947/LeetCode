package Tree;

/**
 * leetcode -- 543.��������ֱ��
 * @author zhx
 */
public class ��������ֱ�� {

    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        //������������Ⱥ͵����ֵ���Ǵ�
        depth(root);
        return res;
    }
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        int L = depth(root.left);
        int R = depth(root.right);
        res = Math.max(L+R, res);
        return Math.max(L, R) + 1;
    }
}
