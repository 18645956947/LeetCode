package 牛客左神初级班.二叉树;

/**
 * 计算完全二叉树的节点个数
 * 要求时间复杂度小于O(N)
 * @author zhx
 */
public class CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static int nodeNum(Node head){
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     *
     * @param node 当前节点
     * @param l 当前节点在第几层
     * @param h 真个树的深度
     * @return 以node开头的树的节点个数
     */
    public static int bs(Node node, int l, int h){
        //来到了叶节点
        if(l == h){
            return 1;
        }
        //看是否右子树的最左边界到底
        if(mostLeftLevel(node.right, l + 1) == h){
            // 1 << h - l 等同于 2^(h - l)
            return (1 << (h - l)) + bs(node.right, l+1, h);

        }
        //否则的话就是左子树是满二叉树 满足节点个数公式2^深度 - 1 此时左子树是又是一颗完全二叉树，继续递归下去
        else {
            return (1 << (h - l - 1)) + bs(node.left, l + 1, h);
        }
    }
    public static int mostLeftLevel(Node node, int level){
        while (node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}

