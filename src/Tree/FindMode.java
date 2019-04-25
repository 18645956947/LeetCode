package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * @author zhx
 */
public class FindMode {
    TreeNode pre = null;
    int cur = 1;
    int max_count = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        int[] a = new int[res.size()];
        for(int i = 0;i<a.length;i++){
            a[i] = res.get(i);
        }
        return a;
    }
    private void inOrder(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        inOrder(node.left, res);
        if(pre != null){
            if(pre.val == node.val){
                cur += 1;
            }
            else{
                cur = 1;
            }
        }
        if(cur > max_count){
            max_count = cur;
            res.clear();
            res.add(node.val);
        }
        else if(cur == max_count){
            res.add(node.val);
        }

        if(pre == null){
            pre = new TreeNode(node.val);
        }
        else{
            pre.val = node.val;
        }
        inOrder(node.right, res);
    }
}
