package Tree;

/**
 * 235. �����������������������
 * @author zhx
 */
public class LowestCommonAncestor {
    //�ݹ�ķ���
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        else{
            return root;
        }
    }

    //�����ķ���
    public TreeNode lowestCommonAncestor_01(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }


}
