package ��ָoffer.��;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * ��ָoffer - ��֮����˳���ӡ������
 * @author zhx
 */
public class ��֮����˳���ӡ������  {
    /**
     * ��һ�ַ����������ܶ��list Ȼ��������ż��ת
     * �������ַ����ں���������ǰ����
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print_01(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<TreeNode> list = new ArrayList();
        if(pRoot == null){
            return res;
        }
        list.add(pRoot);
        boolean flag = true;
        while(!list.isEmpty()){
            ArrayList<TreeNode> nextNode = new ArrayList();
            ArrayList<Integer> cur = new ArrayList();
            for(TreeNode a : list){
                cur.add(a.val);
                if(a.left != null){
                    nextNode.add(a.left);
                }
                if(a.right != null){
                    nextNode.add(a.right);
                }
            }
            if(!flag){
                Collections.reverse(cur);
            }
            res.add(cur);
            flag = !flag;
            list = nextNode;
        }
        return res;
    }
}
