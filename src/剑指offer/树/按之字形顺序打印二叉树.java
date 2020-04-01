package 剑指offer.树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 剑指offer - 按之字形顺序打印二叉树
 * @author zhx
 */
public class 按之字形顺序打印二叉树  {
    /**
     * 第一种方法，创建很多个list 然后利用奇偶反转
     * 但是这种方法在海量数据面前很慢
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
