package Tree;

/**
 * 110. Æ½ºâ¶þ²æÊ÷
 * @author zhx
 * @data 2019.3.20
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)&&
                (Math.abs(depth(root.left) - depth(root.right)) > 1 ? false : true);
    }
    public int depth(TreeNode root){
        if(root == null) return 0;
        return Math.max(depth(root.left), depth(root.right))+1;
    }
}