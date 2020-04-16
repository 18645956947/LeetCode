package List; 

/** 
* @author ZHX
* @date 2019年3月15日下午2:25:28 
* @Description: 83. 删除排序链表中的重复元素
* 
*/
public class DeleteDuplicates_1 {
	public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode root = new ListNode(-1);
        root.next = head;
        ListNode cur = root.next;
        ListNode pre = root;
        while (cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                while (cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(2);
        l1.next.next.next = new ListNode(2);
        l1.next.next.next.next = new ListNode(3);
        System.out.println(DeleteDuplicates_1.deleteDuplicates(l1).val);
	}
}
 