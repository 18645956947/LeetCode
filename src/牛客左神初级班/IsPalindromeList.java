package 牛客左神初级班;

import java.util.Stack;

/**
 * 测试链表是否是回文链表
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
    //空间复杂度O(N)
    //1.方法一：利用一个栈的后进先出的性质来存储
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

    //空间复杂度O(N/2)
    //利用一个快慢指针，快指针一次走两步，慢指针一次走一步
    //快指针走到头后，慢指针走到链表的中间位置
    //然后用一个辅助栈存储后半部分
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

    //空间复杂度O(1)
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
        fast = slow.next; // fast -> 右边部分的第一个节点
        slow.next = null;  // mid.next -> null
        Node n = null;
        while (fast != null){ // 右边部分反转
            n = fast.next; // n -> 保存下一个节点
            fast.next = slow;
            slow = fast; // 继续向下运行
            fast = n; // 继续向下运行
        }
        n = slow; // n -> 最后一个节点
        fast = head; // 左边的第一个节点
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
