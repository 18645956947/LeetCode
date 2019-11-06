package ţ�����������.������;

/**
 * ��Ŀ��������һ��������������ڵ㣬��������ڵ�ĺ�̽ڵ�
 * ǰ���ڵ㣺��һ�ö�������������������������˳�򣬵�ǰ�ڵ��ǰһ���ڵ�Ϊ�ýڵ��ǰ���ڵ㣻
 * ��̽ڵ㣺��һ�ö�������������������������˳�򣬵�ǰ�ڵ�ĺ�һ���ڵ�Ϊ�ýڵ�ĺ�̽ڵ㣻
 * @author zhx
 */
public class SuccessorNode {

    public static class Node{
        public int value;
        public Node parent;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static Node getSuccessorNode(Node node){
        if(node == null){
            return null;
        }
        //1.����ýڵ����������Ļ�������������������Ľڵ�
        if(node.right != null){
            return getRightNode(node.right);
        }
        //2.û���������Ļ�����ôֱ��������ÿ���ڵ�ĸ��ڵ����ڵ��ǵ�ǰ�ڵ�
        Node parent = node.parent;
        while (parent != null && node != parent.left){
            node = parent;
            parent = node.parent;
        }
        return parent;
    }


    public static Node getRightNode(Node node){
        if(node == null){
            return null;
        }
        Node cur = node;
        while (cur.left != null){
            cur = cur.left;
        }
        return cur;
    }
    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
    }

}

