package Tree;

import java.util.*;

/**
 * leetcode - �������������������
 * ˼·���� �� ������һ�����д洢���еİ���pq�Ľڵ㣬���ò�α���
 * һ�� Map�洢���нڵ��Ӧ�ĸ��ڵ���ֵ�
 * Ȼ���ڴ洢�����еĽڵ��ʱ����һ��set��¼p���еĸ��ڵ㣬Ȼ�����q�ĸ��ڵ㣬��һ����p��set��ľ��ǵ�һ�������ڵ�
 * @author zhx
 */
public class ������������������� {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque();
        Map<TreeNode, TreeNode> parent = new HashMap();
        parent.put(root, null);
        stack.push(root);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }
        Set<TreeNode> set = new HashSet();
        while(p != null){
            set.add(p);
            p = parent.get(p);
        }
        while(!set.contains(q)){
            q = parent.get(q);
        }
        return q;

    }
}
