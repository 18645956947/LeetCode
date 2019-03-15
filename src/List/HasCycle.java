package List;

import java.util.HashSet;
import java.util.Set;

/** 
* @author ZHX
* @date 2019��3��15������2:27:44 
* @Description: 141. ��������
*/
public class HasCycle {
	//�ⷨһ�����ÿ���ָ��ʱ��ĸ��Ӷ�O(1),�ռ临�Ӷ�O(n)
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
		
		//�ⷨ��  ����set���� ʱ��ĸ��Ӷ�O(n),�ռ临�Ӷ�O(n)
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
 