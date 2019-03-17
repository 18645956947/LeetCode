package Tree;

/**
 * @author zhx
 * @data 2019年3月17日上午11:05:00
 * 100. 相同的树
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val  != q.val){
            return false;
        }
        else{
            return isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
        }
    }
}
