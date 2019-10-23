package 牛客左神初级班;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现深度拷贝
 * 方法一:空间复杂度O(N) 利用一个哈希表
 * 方法二;空间复杂度O(1)利用一个链表几个变量实现
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

    // 用一个哈希表来存储，思路就是先复制 每个节点，之后再复制每个节点对应的 next rand指针对应的节点
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
        //1.先对应复制下 1-> 1' -> 2 -> 2' -> 3 -> 3'...
        Node cur = head;
        Node next = null;
        while (cur!=null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //2.然后再复制相应的next rand指针对应的节点
        Node curCopy = null;
        cur = head;
        while (cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        //3.再断开1 -> 1' 的next指针
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
