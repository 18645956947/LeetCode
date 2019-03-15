package List; 

/** 
* @author lenovo
* @date 2019年3月15日上午9:56:11 
* @Description: 148. 排序链表
*/
//148. 排序链表
public class SortList {
	public ListNode sortList(ListNode head) {
        return head == null ?null : mergeSort(head);
    }
    
    public ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = null;
        while(fast != null && fast.next != null){
            pre = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        pre.next = null;
        ListNode l = mergeSort(head);
        ListNode r = mergeSort(slow);
        return merge(l, r);
        
    }
    
    public ListNode merge(ListNode l, ListNode r){
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l != null && r != null){
           if(l.val <= r.val){
               cur.next = l;
               cur = cur.next;
               l = l.next;
               
           } else{
               cur.next = r;
               cur = cur.next;
               r = r.next;
               
           }
            
        }
        if(l != null){
            cur.next = l;
        }
        if(r != null){
            cur.next = r;
        }
        return dummyHead.next;
    }
}
 