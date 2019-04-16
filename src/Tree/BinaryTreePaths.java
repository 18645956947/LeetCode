package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 * @author zhx
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        tree(root, "", res);
        return res;

    }
    public String tree(TreeNode root, String s, List<String> list){
        if(root.left!=null){
            tree(root.left, s + root.val+"->", list);
        }
        if(root.right!=null){
            tree(root.right, s + root.val+"->", list);
        }
        if(root.left ==null && root.right == null){
            list.add(s + root.val);
        }
        return s;
    }
}
