package List; 

/** 
* @author ZHX
* @date 2019年3月15日下午2:19:05 
* @Description: 21. 合并两个有序链表
*/
public class MergeTwoLists {
	  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			ListNode head = new ListNode(0);
			if(l1 == null) {
				return l2;
			}
			if(l2 == null) {
				return l1;
			}
			ListNode temp = head;
			while(l1 != null && l2 != null) {
				if(l1.val <= l2.val) {
					temp.next = l1;
					l1 = l1.next;
				}
				else {
					temp.next = l2;
					l2 = l2.next;
				}
				temp = temp.next;
			}
			temp.next = l1 == null ?l2:l1;
			return head.next;  
		}
}
 