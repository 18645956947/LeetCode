package Coding_Interviews;

/**
 * ��ָoffer---�����л�����ڽ��
 * @author zhx
 */
public class �����л�����ڽ�� {

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
