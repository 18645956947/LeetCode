package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode - 662. 二叉树最大宽度
 * @author zhx
 * 思路：
 * 自己封装一个数据结构 里面包含原有的TreeNode 节点，该节点在二叉树的深度，以及该节点在二叉树的位置信息
 * 然后默认第一个出队的节点就是二叉树中这一层的最左边的节点，然
 * 后每次判断一下现在的深度是不是这一层，每一个节点都算一下宽度然后取最大的宽度返回
 *
 */
public class 二叉树最大宽度 {
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
