package List; 

/** 
* @author ZHX
* @date 2019��3��15������2:25:28 
* @Description: 83. ɾ�����������е��ظ�Ԫ��
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
 