package Coding_Interviews;

import java.util.ArrayList;
import util.TreeNode;

/**
 * ��ָoffer -- �����������ĵ�k�����
 * @author zhx
 */
public class �����������ĵ�k����� {

    ArrayList<TreeNode> res = new ArrayList();
    TreeNode KthNode(TreeNode pRoot, int k) {
        //�������������
        if(pRoot == null || k == 0){
            return null;
        }
        inorder(pRoot);
        if(k <= res.size()){
            return res.get(k-1);
        }
        else{
            return null;
        }

    }
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null){
            inorder(root.left);
        }
        res.add(root);
        if(root.right != null){
            inorder(root.right);
        }
    }
}
