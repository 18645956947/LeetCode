package ţ�����������;

import java.util.HashMap;
import java.util.Map;

/**
 * ʵ����ȿ���
 * ����һ:�ռ临�Ӷ�O(N) ����һ����ϣ��
 * ������;�ռ临�Ӷ�O(1)����һ������������ʵ��
 * @author zhx
 */
public class CopyListWithRandom {

    public static class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int value){
            this.value = value;
        }
    }

    // ��һ����ϣ�����洢��˼·�����ȸ��� ÿ���ڵ㣬֮���ٸ���ÿ���ڵ��Ӧ�� next randָ���Ӧ�Ľڵ�
    public static Node copyListWithRand1(Node head){
        Node cur = head;
        Map<Node, Node> map = new HashMap();
        while (cur!=null){
            map.put(cur, new Node(cur.value));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
    public static void printNode(Node head){
        if(head == null){
            return;
        }
        Node  cur = head;
        while (cur != null){
            System.out.println(cur.value);
            cur = cur.next;
        }
    }

    public static Node copyListWithRand2(Node head){
        if (head == null) {
            return null;
        }
        //1.�ȶ�Ӧ������ 1-> 1' -> 2 -> 2' -> 3 -> 3'...
        Node cur = head;
        Node next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //2.Ȼ���ٸ�����Ӧ��next randָ���Ӧ�Ľڵ�
        Node curCopy = null;
        cur = head;
        while (cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        //3.�ٶϿ�1 -> 1' ��nextָ��
        Node res = head.next;
        cur = head;
        while (cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    public static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.rand = head.next.next.next.next.next; // 1 -> 6
        head.next.rand = head.next.next.next.next.next; // 2 -> 6
        head.next.next.rand = head.next.next.next.next; // 3 -> 5
        head.next.next.next.rand = head.next.next; // 4 -> 3
        head.next.next.next.next.rand = null; // 5 -> null
        head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");

    }
}
