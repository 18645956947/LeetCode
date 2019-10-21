package ţ�����������;

import java.util.Stack;

/**
 * ���������Ƿ��ǻ�������
 * @author zhx
 */
public class IsPalindromeList {


    public static class Node{
        public int value;
        public Node next;

        public Node(int data){
            this.value = data;
        }

    }
    //�ռ临�Ӷ�O(N)
    //1.����һ������һ��ջ�ĺ���ȳ����������洢
    public static boolean isPalindrome1(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while (!stack.isEmpty()){
            cur = stack.pop();
            if(cur.value != head.value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //�ռ临�Ӷ�O(N/2)
    //����һ������ָ�룬��ָ��һ������������ָ��һ����һ��
    //��ָ���ߵ�ͷ����ָ���ߵ�������м�λ��
    //Ȼ����һ������ջ�洢��벿��
    public static boolean isPalindrome2(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node slow = head.next;
        Node fast = head;

        while (slow.next!=null && slow.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        Stack<Node> stack = new Stack<>();
        while (slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        while (!stack.isEmpty()){
            if(head.value != stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    //�ռ临�Ӷ�O(1)
    public static boolean isPalindrome3(Node head){
        if(head == null || head.next == null){
            return true;
        }
        Node fast = head;
        Node slow = head;

        while (fast.next!=null && fast.next.next!=null){// find mid node
            fast = fast.next.next; // slow -> mid
            slow = slow.next; // fast -> end
        }
        fast = slow.next; // fast -> �ұ߲��ֵĵ�һ���ڵ�
        slow.next = null;  // mid.next -> null
        Node n = null;
        while (fast != null){ // �ұ߲��ַ�ת
            n = fast.next; // n -> ������һ���ڵ�
            fast.next = slow;
            slow = fast; // ������������
            fast = n; // ������������
        }
        n = slow; // n -> ���һ���ڵ�
        fast = head; // ��ߵĵ�һ���ڵ�
        boolean res = true;
        while (slow != null && fast != null){
            if(slow.value != fast.value){
                res = false;
                break;
            }
            slow = slow.next;
            fast = fast.next;
        }
        slow = n.next;
        n.next = null;
        while (slow != null){
            fast = slow.next;
            slow.next = n;
            n = slow;
            slow = fast;
        }
        return res;
    }
    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }
}
