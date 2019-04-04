package Tree;

import sun.reflect.generics.tree.Tree;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 102. �������Ĳ�α���
 * @author zhx
 * @data 2019��03��18��
 *
 */
public class LevelOrder {
    /**
     * �ݹ����
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int  size = queue.size();
            List<Integer> tem = new ArrayList<Integer>();
            for(int i=0;i<size;i++) {
                TreeNode node = queue.poll();
                tem.add(node.val);
                if(node.left!=null) {
                    queue.offer(node.left);
                }
                if(node.right!=null) {
                    queue.offer(node.right);
                }
            }
            result.add(tem);
        }
        return result;
    }

    /**
     * �ǵݹ�ʵ�ֶ������Ĳ������
     * @param root ���ĸ��ڵ�
     * @return һ��[]
     */
    public List<List<Integer>> levelOrder_1(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return result;
        }
        list.add(root);
        while (!list.isEmpty()){
            List<TreeNode> nextTreeNode = new ArrayList<TreeNode>();
            List<Integer> curList = new ArrayList<>();
            for(TreeNode  node : list){
                curList.add(node.val);
                if(node.left != null){
                    nextTreeNode.add(node.left);
                }
                if(node.right != null){
                    nextTreeNode.add(node.right);
                }
            }
            list = nextTreeNode;
            result.add(curList);
        }
        return result;
    }
}
