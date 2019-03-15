package List;

import java.util.HashSet;
import java.util.Set;

/** 
* @author ZHX
* @date 2019年3月15日下午2:27:44 
* @Description: 141. 环形链表
*/
public class HasCycle {
	//解法一：采用快慢指针时间的复杂度O(1),空间复杂度O(n)
		public boolean hasCycle(ListNode head) {
	        ListNode fast = head;
	        ListNode slow  = head;
	        while(head == null|| head.next == null){
	            return false;
	        }
	        while(fast.next != null&&fast.next.next != null){
	            slow = slow.next;
	            fast = fast.next.next;
	            
	            if(fast == slow){
	                return true;
	            }            
	        }
	        return false;
	    }
		
		//解法二  采用set集合 时间的复杂度O(n),空间复杂度O(n)
		public boolean hasCycle_01(ListNode head) {
			Set<ListNode> set = new HashSet<>();
			ListNode node = head;
			if(head == null || head.next == null) {
				return false;
			}
			while(node != null) {
				if(set.contains(node)) {
					return true;
				}
				else {
					set.add(node);
				}
				node = node.next;
			}
			return false;
		}
}
 