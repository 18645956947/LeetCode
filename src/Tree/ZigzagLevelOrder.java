package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 103. �������ľ���β�α���
 * @author zhx
 * ��102�������Ĳ������һ������������һ��flag ������һ��Collections������ ��list�е�Ԫ�ط�ת�ͺ���
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<TreeNode>();
        if (root == null) {
            return result;
        }
        list.add(root);
        boolean flag = true;
        while (!list.isEmpty()){
            List<TreeNode> nextNode = new ArrayList<TreeNode>();
            List<Integer> curList = new ArrayList<>();
            for(TreeNode node : list){
                curList.add(node.val);
                if (node.left != null) {
                    nextNode.add(node.left);
                }
                if (node.right != null) {
                    nextNode.add(node.right);
                }
            }
            if(flag){
                Collections.reverse(curList);
            }
            flag = !flag;
            result.add(curList);
            list = nextNode;
        }
        return result;
    }
}
