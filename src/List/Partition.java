package List;

/**
 * 86. 分隔链表
 * @author zhx
 */
public class Partition {

    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);//学会利用头指针
        ListNode more  = new ListNode(0);

        ListNode less_ptr = less;
        ListNode more_ptr = more;
        ListNode cur = head;
        while(cur != null) {
            if(cur.val < x){
                less_ptr.next = cur;
                less_ptr = less_ptr.next;
            }
            else{
                more_ptr.next = cur;
                more_ptr = more_ptr.next;
            }
            cur = cur.next;

        }
        less_ptr.next = more.next;
        more_ptr.next = null;
        return less.next;
    }
}
