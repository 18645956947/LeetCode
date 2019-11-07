package ţ�����������.������;

/**
 * ������ȫ�������Ľڵ����
 * Ҫ��ʱ�临�Ӷ�С��O(N)
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
     * @param node ��ǰ�ڵ�
     * @param l ��ǰ�ڵ��ڵڼ���
     * @param h ����������
     * @return ��node��ͷ�����Ľڵ����
     */
    public static int bs(Node node, int l, int h){
        //������Ҷ�ڵ�
        if(l == h){
            return 1;
        }
        //���Ƿ�������������߽絽��
        if(mostLeftLevel(node.right, l + 1) == h){
            // 1 << h - l ��ͬ�� 2^(h - l)
            return (1 << (h - l)) + bs(node.right, l+1, h);

        }
        //����Ļ��������������������� ����ڵ������ʽ2^��� - 1 ��ʱ������������һ����ȫ�������������ݹ���ȥ
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

