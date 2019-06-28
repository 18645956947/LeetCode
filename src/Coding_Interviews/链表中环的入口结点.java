package Coding_Interviews;

/**
 * 剑指offer---链表中环的入口结点
 * @author zhx
 */
public class 链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead){

        if(pHead == null || pHead.next == null || pHead.next.next == null){
            return null;
        }

        ListNode first = pHead.next.next;
        ListNode slow = pHead.next;
        while(first != slow){
            if(first.next.next != null && first.next != null){
                first = first.next.next;
                slow = slow.next;
            }
            else{
                return null;
            }
        }
        ListNode cur = pHead;
        while(cur != slow){
            slow = slow.next;
            cur = cur.next;
        }
        return cur;
    }
}
