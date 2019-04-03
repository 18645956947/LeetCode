package Tree;

import sun.net.ftp.FtpClient;

/**
 * 114. 二叉树展开为链表
 * @author zhx
 */
public class Flatten {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            flatten(root.left);
        }
        if(root.right!= null){
           flatten(root.right);
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null){
            root = root.right;
        }
        root.right = temp;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.left = new TreeNode(7);
        Flatten flatten = new  Flatten();
        flatten.flatten(root);
        while(root!=null){
            System.out.println(root.val);
            root = root.right;
        }
    }
}

