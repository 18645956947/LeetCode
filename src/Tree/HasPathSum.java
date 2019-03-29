package Tree;

import java.util.Stack;

/**
 * 112. 路径总和
 * @author zhx
 */
public class HasPathSum {
    /**
     * 递归 操作
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(sum == root.val && root.left == null && root.right == null){
            return true;
        }
        else return hasPathSum(root.left, sum - root.val) ||hasPathSum(root.right, sum - root.val);
    }

    /**
     * 迭代操作
     */
    public boolean hasPathSum_(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<TreeNode> path = new Stack<>();
        Stack<Integer> sub = new Stack<>();
        path.push(root);
        sub.push(root.val);
        while(!path.isEmpty()){
            TreeNode temp = path.pop();
            int tempVal = sub.pop();
            if(temp.left == null && temp.right == null){
                if(tempVal == sum){
                    return true;
                }
            }
            else{
                if(temp.left!=null){
                    path.push(temp.left);
                    sub.push(temp.left.val + tempVal);
                }
                if(temp.right!= null){
                    path.push(temp.right);
                    sub.push(temp.right.val + tempVal);
                }
            }
        }
        return false;
    }

}
