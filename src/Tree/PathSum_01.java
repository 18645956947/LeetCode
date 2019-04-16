package Tree;

import sun.reflect.generics.tree.Tree;

/**
 * 437. Â·¾¶×ÜºÍ III
 * @author zhx
 */
public class PathSum_01 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null){
            return 0;
        }
        int res = findPath(root, sum);
        res +=  pathSum(root.left, sum);
        res +=  pathSum(root.right, sum);
        return res;
    }
    private int findPath(TreeNode node, int sum){
        if(node == null){
            return 0;
        }
        int res = 0;
        if(node.val == sum){
            res += 1;
        }
        res += findPath(node.left, sum - node.val);
        res += findPath(node.right, sum - node.val);
        return res;
    }
}
