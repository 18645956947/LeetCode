package List; 

/** 
* @author lenovo
* @date 2019年3月13日上午10:02:03 
* @Description: 328. 奇偶链表
*/
//思路就是用两个快慢指针 
//328. 奇偶链表
public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = p.next;
        ListNode newNode = q;
        while(q != null && q.next != null){
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;
        }
        p.next = newNode;
        return head;
    }
}
 