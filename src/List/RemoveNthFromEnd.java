package List;

//19. 删除链表的倒数第N个节点
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
       ListNode f = head;
	   ListNode s = head;
		for (int i = 0; i < n; i++) {
			f = f.next;
		}
		if(f == null) {
			return head = head.next;
		}
		while(f.next!=null) {
			f = f.next;
			s = s.next;
		}
		s.next = s.next.next;
		return head;
    }
}