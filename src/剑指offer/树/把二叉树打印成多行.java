package ��ָoffer.��;

import java.util.ArrayList;

/**
 * ��ָoffer - �Ѷ�������ӡ�ɶ���
 * @author zhx
 */
public class �Ѷ�������ӡ�ɶ��� {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<TreeNode> list = new ArrayList();
        if(pRoot == null){
            return res;
        }
        list.add(pRoot);

        while(!list.isEmpty()){
            ArrayList<Integer> cur = new ArrayList();
            ArrayList<TreeNode> next = new ArrayList();
            for(TreeNode n : list){
                cur.add(n.val);
                if(n.left != null){
                    next.add(n.left);
                }
                if(n.right != null){
                    next.add(n.right);
                }
            }
            list = next;
            res.add(cur);
        }
        return res;
    }
}

