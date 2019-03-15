package List;

import java.util.Stack;

import zhx.day1224.ListNode;

/** 
* @author ZHX
* @date 2019年3月15日下午2:19:40 
* @Description: 234. 回文链表
*/
public class IsPalindrome {
	public boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		if(head==null||head.next==null) {
			return true;
		}
		ListNode p = head;
		while(p != null) {
			stack.push(p);
			p = p.next;
		}
		ListNode qListNode = head;
		while(qListNode != null) {
			if (qListNode.val != stack.pop().val) {
				return false;
			}
			qListNode = qListNode.next;
		}
		return true;
        
    }
}
 