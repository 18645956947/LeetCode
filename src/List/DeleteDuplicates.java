package List;

/** 
* @author lenovo
* @date 2019年3月15日下午1:41:30 
* @Description: 2. 删除排序链表中的重复元素 II
*  采用双指针方法
*/


public class DeleteDuplicates {

	public static ListNode deleteDuplicates(ListNode head) {
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
	public static void main(String[] args) {
		List.ListNode l1 = new List.ListNode(1);
		l1.next = new List.ListNode(1);
		l1.next.next = new List.ListNode(3);
		l1.next.next.next = new List.ListNode(3);
		l1.next.next.next.next = new List.ListNode(4);
		System.out.println(DeleteDuplicates_1.deleteDuplicates(l1).val);
	}
} 
 