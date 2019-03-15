package List; 

/** 
* @author lenovo
* @date 2019��3��13������10:02:03 
* @Description: 328. ��ż����
*/
//˼·��������������ָ�� 
//328. ��ż����
public class OddEvenList {
	public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode p = head;
        ListNode q = p.next;
        ListNode newNode = q;
        while(q != null && q.next != null){
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;
        }
        p.next = newNode;
        return head;
    }
}
 