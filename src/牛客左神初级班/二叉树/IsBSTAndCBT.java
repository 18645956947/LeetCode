package ţ�����������.������;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * �ж��Ƿ��Ƕ���������
 * �ж��Ƿ�����ȫ������
 * @author zhx
 */
public class IsBSTAndCBT {

    //�ж��Ƿ��Ƕ���������
    //˼·�ǣ��������������������Ƿ��ǰ�����ֵ����������
    //����дһ�����������������
    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }

    public static boolean isBST(Node head){
        if(head != null){
            double pre = - Double.MAX_VALUE;
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    if(head.value <= pre){
                        return false;
                    }
                    pre = head.value;
                    head = head.right;
                }
            }
        }
        return true;
    }

    //��֤�Ƿ�����ȫ������
    //һ�����ֿ����ԣ�
    //1.���һ���ڵ���������û����������ôֱ�ӷ���false
    //2.���һ���ڵ�������������������Ϊ�ջ�������������,��ô�����ڵ㶼Ӧ����Ҷ�ӽڵ�
    public static boolean isCBT(Node head){
        if(head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean leaf = false;
        Node l = null;
        Node r = null;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            l = head.left;
            r = head.right;
            if((l == null && r != null) || (leaf && (l != null || r != null))){
                return false;
            }
            if(l != null){
                queue.offer(l);
            }
            if(r != null){
                queue.offer(r);
            }
            //�����ж�����Ҷ�ӽڵ��Ƿ�Ϊ�յĽ׶�
            else{
                leaf = true;
            }
        }
        return true;
    }
    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }
}
