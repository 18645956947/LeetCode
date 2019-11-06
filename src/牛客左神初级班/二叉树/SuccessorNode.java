package 牛客左神初级班.二叉树;

/**
 * 题目描述：给一个二叉树的随机节点，查找这个节点的后继节点
 * 前驱节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的前一个节点为该节点的前驱节点；
 * 后继节点：对一棵二叉树进行中序遍历，遍历后的顺序，当前节点的后一个节点为该节点的后继节点；
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
        //1.如果该节点有右子树的话，就找右子树的最左的节点
        if(node.right != null){
            return getRightNode(node.right);
        }
        //2.没有右子树的话，那么直接向上找每个节点的父节点的左节点是当前节点
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

