package List;

/** 
* @author lenovo
* @date 2019��3��15������1:41:30 
* @Description: 2. ɾ�����������е��ظ�Ԫ�� II
*  ����˫ָ�뷽��
*/
public class DeleteDuplicates {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode deleteDuplicates(ListNode head) {
	   if(head == null || head.next == null){
	       return head;
	   }
	   ListNode h = new ListNode(-1);
	   h.next = head;
	   ListNode pre = h;
	   ListNode cur = head;
	   while(cur != null){
	       boolean flag = true;
	       while(cur.next != null && cur.val == cur.next.val){
	           cur = cur.next;
	           flag = false;
	       }
	       if(flag){ 
	           pre = cur;
        } else{
	           pre.next = cur.next;
        }
	        cur = cur.next;
	    }
	    return h.next;
	}
} 
 