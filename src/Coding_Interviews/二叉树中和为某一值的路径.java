package Coding_Interviews;

import util.InsertTreeNode;
import util.TreeNode;

import java.util.ArrayList;

/**
 * ��ָoffer -- �������к�Ϊĳһֵ��·��
 * @author zhx
 */
public class �������к�Ϊĳһֵ��·�� {


    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return res;
        }

        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left ==null && root.right == null){
            res.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size()-1);
        return res;
    }

    public static void main(String[] args) {
        �������к�Ϊĳһֵ��·�� q = new �������к�Ϊĳһֵ��·��();
        TreeNode root = InsertTreeNode.insertTreeNode();
        ArrayList<ArrayList<Integer>> ll = q.FindPath(root, 7);
        System.out.println(ll);
    }
}
