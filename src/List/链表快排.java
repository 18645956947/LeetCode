package List;


public class Á´±í¿ìÅÅ {
    public static ListNode quickSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode d = new ListNode(-1);
        d.next = head;
        return process(d, null);
    }
    private static ListNode process(ListNode head, ListNode end){

        if (head == end || head.next == end || head.next.next == end){
            return head;
        }
        ListNode d = new ListNode(-1);
        ListNode partition = head.next, p = partition, temp = d;
        while (p.next != end){
            if (p.next.val < partition.val){
                temp.next = p.next;
                temp = temp.next;
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        temp.next = head.next;
        head.next = d.next;
        process(head, partition);
        process(partition, end);
        return head.next;

    }
    public static void pr(ListNode c){
        while (c != null){
            System.out.print(c.val + " ");
            c = c.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(4);
        root.next.next.next.next.next.next = new ListNode(3);
        pr(root);
        ListNode c = quickSort(root);
        pr(c);

    }
}
