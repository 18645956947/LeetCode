package List; 

/** 
* @author ZHX
* @date 2019年3月15日下午2:25:28 
* @Description: 83. 删除排序链表中的重复元素
* 
*/
public class DeleteDuplicates_1 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        while(p.next!=null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }
        }
        return head;
        
    }
}
 