package 牛客左神初级班;

/**
 * 链表反转
 * @author zhx
 */
public class ReverseList {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }

    public static Node reverseList(Node head){
        if(head == null){
            return null;
        }
        Node pre = null;
        Node cur = head;
        Node post;
        while (cur != null){
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }
    public static void printNode(Node head){
        Node node = ReverseList.reverseList(head);
        while (node!=null){
            System.out.println(node.value);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Node head  = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        ReverseList.printNode(head);
    }
}
