package Coding_Interviews;

/**
 * ½£Ö¸offer---¶þ²æÊ÷µÄ¾µÏñ
 * @author zhx
 */
public class ¶þ²æÊ÷µÄ¾µÏñ {

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
