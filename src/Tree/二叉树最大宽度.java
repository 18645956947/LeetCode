package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode - 662. �����������
 * @author zhx
 * ˼·��
 * �Լ���װһ�����ݽṹ �������ԭ�е�TreeNode �ڵ㣬�ýڵ��ڶ���������ȣ��Լ��ýڵ��ڶ�������λ����Ϣ
 * Ȼ��Ĭ�ϵ�һ�����ӵĽڵ���Ƕ���������һ�������ߵĽڵ㣬Ȼ
 * ��ÿ���ж�һ�����ڵ�����ǲ�����һ�㣬ÿһ���ڵ㶼��һ�¿��Ȼ��ȡ���Ŀ�ȷ���
 *
 */
public class ����������� {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<WidthNode> queue = new LinkedList<>();
        WidthNode r = new WidthNode(root, 1, 1);
        queue.offer(r);
        int cur_d = 1;
        int l = 1;
        int res = 1;

        while (!queue.isEmpty()) {
            WidthNode tem = queue.poll();
            if (tem.node.left != null) {
                queue.offer(new WidthNode(tem.node.left, tem.depth + 1, tem.pos * 2));
            }
            if (tem.node.right != null) {
                queue.offer(new WidthNode(tem.node.right, tem.depth + 1, tem.pos * 2 + 1));
            }
            if (cur_d != tem.depth) {
                cur_d = tem.depth;
                l = tem.pos;
            }
            res = Math.max(res, tem.pos - l + 1);

        }
        return res;


    }
    class WidthNode{
        public TreeNode node;
        public int depth;
        public int pos;
        public WidthNode(TreeNode node, int depth, int pos){
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }
}
